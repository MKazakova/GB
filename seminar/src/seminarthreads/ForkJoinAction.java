package seminarthreads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinAction {
public static final int ARRAY_LENGTH = 50;
	
	public static void main(String[] args) {
		   ForkJoinPool pool = new ForkJoinPool();
		   
		   String [] strings = new String[ARRAY_LENGTH];
		   for (int i = 0; i < ARRAY_LENGTH; i++) {
			   strings[i]  = createRandomString();
		   }
		   printStringTable(strings);
		   UpperCaseAction action = new UpperCaseAction(strings);
		   pool.invoke(action);
		   printStringTable(strings);
		   
	}
	
	public static String createRandomString() {
		String letters = "azertyuiopmlkjhgfdsqwxcvbn";
		int stringlength = ThreadLocalRandom.current().nextInt(3, 21);
		String generatedString = "";
		for(int i=0; i<stringlength; i++) {
			generatedString+=letters.charAt(ThreadLocalRandom.current().nextInt(0, letters.length()));
		}
		return generatedString;
	}
	
	public static void printStringTable(String [] strings) {
		for (int i = 0; i < ARRAY_LENGTH; i++) {
		      System.out.print(strings[i] + " ");
		      if(i%5==0&&i!=0) {
		    	  System.out.println();
		      }
		 }
		System.out.println();
	}
}

class UpperCaseAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] strings;
	private int start;
	private int end;
	private int size;
	
	

	public UpperCaseAction(String[] strings, int start, int end) {
		super();
		this.strings = strings;
		this.start = start;
		this.end = end;
		this.size = end - start;
	}

	public UpperCaseAction(String[] strings) {
		this(strings, 0, strings.length);
	}


	@Override
	protected void compute() {
		if(size<=5) {
			tableToUpperCase();
		}
		else {
			int mid = start + size/2;
			UpperCaseAction action1 = new UpperCaseAction(strings, start, mid);
			UpperCaseAction action2 = new UpperCaseAction(strings, mid, end);
			
			invokeAll(action1, action2);
		}
	}
	
	private void tableToUpperCase() {
		for (int i = start; i<end; i++) {
			strings[i] = strings[i].toUpperCase();
		}
	}
	
}
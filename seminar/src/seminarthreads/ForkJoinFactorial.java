package seminarthreads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFactorial {
	
	public static void main (String ...strings) {
		ForkJoinPool pool = new ForkJoinPool();
		CountFactorialTask task = new CountFactorialTask(15);
		System.out.println("Result : "+pool.invoke(task));
	}

}

class CountFactorialTask extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long number1;
	private long number2;
	

	public CountFactorialTask(long number1, long number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}
	public CountFactorialTask(long number) {
		this(1, number);
	}


	@Override
	protected Long compute() {
		if(number1 - number2 <=5) {
			return multiply(number2);
		}
		else {
			long mid = number1 + (number2-number1)/2;
			CountFactorialTask task1 = new CountFactorialTask(number1, mid);
			CountFactorialTask task2 = new CountFactorialTask(mid+1, number2);
			
			task1.fork();
			return task2.compute()*task1.join();
		}
	}
	
	private long multiply(long num) {
		if(num == number1) {
			return number1;
		}
		return num * multiply(num -1);
	}
	
}

package seminarthreads;

public class Test3 {
	
	public static void main(String[] args) {		
		for(int i = 0; i<100; i++) {
			Thread th = new Thread(() -> System.out.println("Thread "+Thread.currentThread().getName()));
			th.start();
		}
	}
}

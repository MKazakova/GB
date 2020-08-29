package seminarthreads;

public class Test2 {

	public static void main(String[] args) {
		
		for(int i = 0; i<100; i++) {
			Thread th = new Thread(new MyRunnableTask());
			th.start();
		}
	}

}

class MyRunnableTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getName());
	}
	
}

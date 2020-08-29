package seminarthreads;

public class Test1 {
	public static void main (String ...strings) {
		MyThread mt = new MyThread();
		MyThread mt2 = new MyThread();
		mt.start();
		mt2.start();
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("Hello from "+this.getName()+"!");
	}
}

package seminarthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test4 {

		public static void main(String ...strings) {
			ExecutorService executor = Executors.newFixedThreadPool(15);
			Runnable r = ()->System.out.println("Thread "+Thread.currentThread().getName());
			
			for(int i = 0; i<100; i++) {
				executor.submit(r);
			}
			
			executor.shutdown();
		}
}

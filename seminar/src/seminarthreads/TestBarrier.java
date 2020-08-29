package seminarthreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBarrier {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(100);
		
		Runnable allSet = () -> System.out.println(" *** All are here ***");
		
		CyclicBarrier barrier = new CyclicBarrier(105, allSet);
		
		Runnable r = ()->{System.out.println("Thread "+Thread.currentThread());
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		};
		
		for(int i =0; i<100; i++) {
			executor.submit(r);
		}
		executor.shutdown();
	}

}
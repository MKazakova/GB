package seminarthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {

	public static void main(String ...strings) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(15);
		Callable<String> c = ()-> {return "Thread "+Thread.currentThread().getName();};
		List<Future<String>> futures = new ArrayList<>();
		
		for(int i = 0; i<100; i++) {
			futures.add(executor.submit(c));
		}
		
		for(Future<String> future: futures) {
			System.out.println(future.get());
		}

		executor.shutdown();
	}

}

package seminarthreads;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test6 {

	public static void main(String ...strings) throws InterruptedException, ExecutionException {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(15);
		Runnable r = ()->System.out.println("Runnable "+LocalTime.now());
		scheduler.schedule(r, 5, TimeUnit.SECONDS);
		scheduler.shutdown();
	}
}

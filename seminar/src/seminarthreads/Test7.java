package seminarthreads;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test7 {

	public static void main(String[] args) throws InterruptedException {
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(15);
			Runnable r = ()->System.out.println("Runnable "+LocalTime.now());
			scheduler.scheduleWithFixedDelay(r, 5, 1, TimeUnit.SECONDS);
			Thread.sleep(15000);
			scheduler.shutdown();
	}

}

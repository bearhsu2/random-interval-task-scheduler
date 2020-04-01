package idv.kuma;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;

public class RandomIntervalSchedulerTest {
    @Test
    public void name() throws InterruptedException {

        RandomIntervalScheduler first = new RandomIntervalScheduler(
                Executors.newScheduledThreadPool(10),
                new SampleTask(),
                new RandomIntervalScheduler.Range(1, 3),
                new RandomIntervalScheduler.Range(4, 9)
        );


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
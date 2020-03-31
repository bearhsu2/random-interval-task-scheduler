package idv.kuma;

import org.junit.Test;

import java.time.LocalDateTime;

public class RandomIntervalTaskSchedulerTest {
    @Test
    public void name() throws InterruptedException {

        RandomIntervalTaskScheduler first = new RandomIntervalTaskScheduler();


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
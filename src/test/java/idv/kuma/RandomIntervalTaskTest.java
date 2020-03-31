package idv.kuma;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;

public class RandomIntervalTaskTest {
    @Test
    public void name() throws InterruptedException {

        RandomIntervalTask first = new RandomIntervalTask(
                Executors.newScheduledThreadPool(10),
                new SampleTask(),
                1, 3,
                4, 9
        );


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
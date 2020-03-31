package idv.kuma;

import org.junit.Test;

import java.time.LocalDateTime;

public class RandomIntervalTaskTest {
    @Test
    public void name() throws InterruptedException {

        RandomIntervalTask first = new RandomIntervalTask(new SampleTask(), 1, 3, 4, 9);


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
package idv.kuma;

import org.junit.Test;

import java.time.LocalDateTime;

public class CustomTimerTaskTest {
    @Test
    public void name() throws InterruptedException {

        CustomTimerTask first = new CustomTimerTask(0);


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
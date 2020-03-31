package idv.kuma;

import org.junit.Test;

public class CustomTimerTaskTest {
    @Test
    public void name() throws InterruptedException {

        CustomTimerTask first = new CustomTimerTask(0);

        first.trigger();

        Thread.sleep(60_000L);

    }
}
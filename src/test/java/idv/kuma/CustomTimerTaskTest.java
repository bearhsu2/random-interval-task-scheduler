package idv.kuma;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomTimerTaskTest {
    @Test
    public void name() throws InterruptedException {

        CustomTimerTask first = new CustomTimerTask(0);

        first.trigger();


        Thread.sleep(30_000L);

    }
}
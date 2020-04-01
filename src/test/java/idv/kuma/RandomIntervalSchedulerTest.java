package idv.kuma;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RandomUtils.class})
public class RandomIntervalSchedulerTest {
    @Test
    public void Schedule_With_Random_Number() {

        ScheduledExecutorService mockedService = Mockito.mock(ScheduledExecutorService.class);

        Runnable mockedRunnable = Mockito.mock(Runnable.class);

        RandomIntervalScheduler randomIntervalScheduler = new RandomIntervalScheduler(
                mockedService,
                mockedRunnable,
                new Range(1000L, 1001L),
                new Range(3000L, 3001L)
        );

        randomIntervalScheduler.trigger();

        Mockito.verify(mockedService).schedule(any(TaskWrapper.class), eq(1000L), eq(TimeUnit.MILLISECONDS));


    }


    @Test
    public void Illegal_Range() {

    }



    @Ignore
    @Test
    public void name() throws InterruptedException {

        RandomIntervalScheduler first = new RandomIntervalScheduler(
                Executors.newScheduledThreadPool(10),
                new SampleTask(),
                new Range(1, 3),
                new Range(4, 9)
        );


        System.out.println("go:" + LocalDateTime.now());
        System.out.println("--------------------------------------");

        first.trigger();

        Thread.sleep(60_000L);

    }
}
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

        Range firstRange = new Range(1, 2);
        Range secondRange = new Range(3, 4);

        RandomIntervalScheduler randomIntervalScheduler = new RandomIntervalScheduler(
                mockedService,
                mockedRunnable,
                firstRange,
                secondRange
        );

        randomIntervalScheduler.trigger();

        Mockito.verify(mockedService).schedule(any(TaskWrapper.class), eq(1L), eq(TimeUnit.SECONDS));


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
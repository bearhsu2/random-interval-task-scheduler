package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomIntervalTaskScheduler {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
    public final SampleTask sampleTask;


    public RandomIntervalTaskScheduler() {
        sampleTask = new SampleTask(this);
    }


    public void trigger() {
        executorService.schedule(sampleTask, RandomUtils.nextInt(1, 3), TimeUnit.SECONDS);
    }


    void reTrigger() {
        executorService.schedule(sampleTask, RandomUtils.nextInt(4, 9), TimeUnit.SECONDS);
    }


}

package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomIntervalTask extends TimerTask {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    private Runnable task;

    private int firstStart;
    private int firstEnd;
    private int secondStart;
    private int secondEnd;


    public RandomIntervalTask(Runnable task, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        this.task = task;
        this.firstStart = firstStart;
        this.firstEnd = firstEnd;
        this.secondStart = secondStart;
        this.secondEnd = secondEnd;
    }


    public final void trigger() {
        executorService.schedule(this, RandomUtils.nextInt(firstStart, firstEnd), TimeUnit.SECONDS);
    }


    @Override
    public final void run() {
        task.run();

        reTrigger();

    }


    private void reTrigger() {
        executorService.schedule(this, RandomUtils.nextInt(secondStart, secondEnd), TimeUnit.SECONDS);
    }
}

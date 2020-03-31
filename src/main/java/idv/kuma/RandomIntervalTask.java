package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class RandomIntervalTask extends TimerTask {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    private int firstStart;
    private int firstEnd;
    private int secondStart;
    private int secondEnd;


    public RandomIntervalTask(int firstStart, int firstEnd, int secondStart, int secondEnd) {
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
        doRun();

        reTrigger(this);

    }


    abstract void doRun();


    private void reTrigger(RandomIntervalTask command) {
        executorService.schedule(command, RandomUtils.nextInt(secondStart, secondEnd), TimeUnit.SECONDS);
    }
}

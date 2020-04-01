package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomIntervalScheduler {

    private ScheduledExecutorService executorService;
    private TaskWrapper taskWrapper;

    private Range firstRange;

    public RandomIntervalScheduler(ScheduledExecutorService executorService, Runnable task, Range firstRange, Range secondRange) {
        this.executorService = executorService;
        this.firstRange = firstRange;
        this.taskWrapper = new TaskWrapper(executorService, task, secondRange.getStartInclusive(), secondRange.getEndExclusive());
    }


    public void trigger() {
        executorService.schedule(taskWrapper, RandomUtils.nextInt(firstRange.getStartInclusive(), firstRange.getEndExclusive()), TimeUnit.SECONDS);
    }


}

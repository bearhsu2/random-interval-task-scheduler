package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TaskWrapper implements Runnable {


    private Runnable task;
    private long startInclusive;
    private long endExclusive;
    private ScheduledExecutorService executorService;


    public TaskWrapper(ScheduledExecutorService executorService, Runnable task, Range range) {
        this.task = task;
        this.executorService = executorService;
        this.startInclusive = range.getStartInclusive();
        this.endExclusive = range.getEndExclusive();
    }

    @Override
    public void run() {
        task.run();

        executorService.schedule(this, RandomUtils.nextLong(startInclusive, endExclusive), TimeUnit.MILLISECONDS);
    }

}

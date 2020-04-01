package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TaskWrapper implements Runnable {


    private Runnable task;
    private int secondStart;
    private int secondEnd;
    private ScheduledExecutorService executorService;


    public TaskWrapper(ScheduledExecutorService executorService, Runnable task, int secondStart, int secondEnd) {
        this.task = task;
        this.executorService = executorService;
        this.secondStart = secondStart;
        this.secondEnd = secondEnd;
    }

    @Override
    public void run() {
        task.run();

        executorService.schedule(this, RandomUtils.nextInt(secondStart, secondEnd), TimeUnit.SECONDS);
    }

}

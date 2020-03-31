package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomIntervalTask {

    private ScheduledExecutorService executorService;
    private TaskWrapper taskWrapper;

    private int firstStart;
    private int firstEnd;


    public RandomIntervalTask(ScheduledExecutorService executorService, Runnable task, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        this.executorService = executorService;
        this.firstStart = firstStart;
        this.firstEnd = firstEnd;
        this.taskWrapper = new TaskWrapper(executorService, task, secondStart, secondEnd);
    }


    public void trigger() {
        executorService.schedule(taskWrapper, RandomUtils.nextInt(firstStart, firstEnd), TimeUnit.SECONDS);
    }


    private static class TaskWrapper implements Runnable {


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

}

package idv.kuma;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomIntervalTask {

    private ScheduledExecutorService executorService;
    private TaskWrapper taskWrapper;

    private Range firstRange;

    public RandomIntervalTask(ScheduledExecutorService executorService, Runnable task, Range firstRange, Range secondRange) {
        this.executorService = executorService;
        this.firstRange = firstRange;
        this.taskWrapper = new TaskWrapper(executorService, task, secondRange.getStart(), secondRange.getEnd());
    }


    public void trigger() {
        executorService.schedule(taskWrapper, RandomUtils.nextInt(firstRange.getStart(), firstRange.getEnd()), TimeUnit.SECONDS);
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

    static class Range {
        private final int start;
        private final int end;


        Range(int start, int firstEnd) {
            this.start = start;
            this.end = firstEnd;
        }


        public int getStart() {
            return start;
        }


        public int getEnd() {
            return end;
        }
    }
}

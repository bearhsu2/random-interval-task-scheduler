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
        private final int startInclusive;
        private final int endExclusive;


        Range(int startInclusive, int firstEnd) {
            this.startInclusive = startInclusive;
            this.endExclusive = firstEnd;
        }


        public int getStartInclusive() {
            return startInclusive;
        }


        public int getEndExclusive() {
            return endExclusive;
        }
    }
}

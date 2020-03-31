package idv.kuma;

import java.time.LocalDateTime;

public class SampleTask extends RandomIntervalTask {
    private int index;


    public SampleTask(int index, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        super(firstStart, firstEnd, secondStart, secondEnd);
        this.index = index;
    }


    @Override
    public void doRun() {
        System.out.println(index + " start:" + LocalDateTime.now());
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(index + " end:" + LocalDateTime.now());
        System.out.println("--------------------------------------");
        index++;
    }
}

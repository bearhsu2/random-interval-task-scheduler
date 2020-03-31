package idv.kuma;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class SampleTask extends TimerTask {

    private int index;

    private RandomIntervalTaskScheduler retriggerrable;


    public SampleTask(RandomIntervalTaskScheduler retriggerrable) {
        this.retriggerrable = retriggerrable;
    }


    @Override
    public final void run() {
        doRun();

        retriggerrable.reTrigger();
    }


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

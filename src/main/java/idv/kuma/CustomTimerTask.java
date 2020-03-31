package idv.kuma;

import java.time.LocalDateTime;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CustomTimerTask extends TimerTask {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    private int index;

    public CustomTimerTask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(index + " start:" + LocalDateTime.now());
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(index + " end:" + LocalDateTime.now());

        CustomTimerTask next = new CustomTimerTask(index+1);
        executorService.schedule(next, 5, TimeUnit.SECONDS);

    }


    public void trigger() {
        executorService.schedule(this, 5, TimeUnit.SECONDS);
    }
}

package idv.kuma;

import java.time.LocalDateTime;

public class SampleTask implements Runnable {
    private int index;


    @Override
    public void run() {
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

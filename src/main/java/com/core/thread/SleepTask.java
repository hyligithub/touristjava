package com.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class SleepTask extends Liftoff {

    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            e.execute(new SleepTask());
        }
        e.shutdown();
    }
}

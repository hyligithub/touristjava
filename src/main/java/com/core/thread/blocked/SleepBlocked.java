package com.core.thread.blocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException i) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exit from SleepBlocked.run()");
    }
}

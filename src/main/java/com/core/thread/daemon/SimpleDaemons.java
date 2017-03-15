package com.core.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "--" + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SimpleDaemons());
            t.setDaemon(true);//must before start();
            t.start();
        }
        System.out.println("All thread start");
        TimeUnit.MILLISECONDS.sleep(200);
    }
}

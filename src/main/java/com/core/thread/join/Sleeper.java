package com.core.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted." + "interrupted:" + isInterrupted());
            return;
        }
        System.out.println(Thread.currentThread().getName() + " was awakened");
    }
}

package com.core.thread.daemon;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class Daemon implements Runnable {
    @Override
    public void run() {
        Thread[] t = new Thread[10];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon=" + t[i].isDaemon());
        }
        while (true)
            Thread.yield();
    }
}

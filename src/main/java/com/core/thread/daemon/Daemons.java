package com.core.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t.isDaemon=" + t.isDaemon());
        TimeUnit.MILLISECONDS.sleep(1);
    }
}

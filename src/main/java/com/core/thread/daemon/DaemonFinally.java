package com.core.thread.daemon;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class DaemonFinally implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("DaemonFinally has started");
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("DaemonFinally go to finally");
        }
    }
}

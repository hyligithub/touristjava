package com.core.thread.blocked;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class SynchronizedBlocked implements Runnable {
    public synchronized void f(){
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    public void run() {
        System.out.println("call f()");
        f();
        System.out.println("Exit from SynchonizedBlocked.run();");
    }
}

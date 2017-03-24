package com.core.thread.waitnotify;

/**
 * Created by lihuiyan on 2017/3/23.
 */
public class Blocker {
    synchronized void waitingCall() {
        try {
            wait();
            System.out.println(Thread.currentThread() + " ");
        } catch (InterruptedException e) {

        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

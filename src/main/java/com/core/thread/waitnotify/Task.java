package com.core.thread.waitnotify;

/**
 * Created by lihuiyan on 2017/3/23.
 */
public class Task implements Runnable {
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}

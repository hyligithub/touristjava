package com.core.thread.exception;

import java.util.concurrent.ThreadFactory;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class HandlerThreadFactory implements ThreadFactory {
    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh=" + t.getUncaughtExceptionHandler());
        return t;
    }
}

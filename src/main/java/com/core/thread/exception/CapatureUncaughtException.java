package com.core.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class CapatureUncaughtException {
    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool(new HandlerThreadFactory());
        e.execute(new ExecptionThread2());

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService e2 = Executors.newCachedThreadPool();
        e2.execute(new ExecptionThread2());
    }
}


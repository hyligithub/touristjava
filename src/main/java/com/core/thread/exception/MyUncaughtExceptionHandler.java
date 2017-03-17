package com.core.thread.exception;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     *
     * @param t the thread
     * @param e the exception
     */
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught:" + e);
    }
}

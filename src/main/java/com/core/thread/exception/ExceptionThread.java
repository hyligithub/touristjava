package com.core.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class ExceptionThread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("run exception");
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorService e = Executors.newCachedThreadPool();
            e.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println("exception");
        }
    }
}

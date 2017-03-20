package com.core.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/18.
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getValue() {
        return i;
    }//not safe

    public synchronized void evenIncrement() {
        i++;
        i++;
    }

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
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        e.execute(at);
        while (true) {
            int value = at.getValue();
            System.out.println(value);
            if (value % 2 != 0) {
                System.out.println(value + " break;");
                System.exit(0);
            }
        }
    }
}

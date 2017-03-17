package com.core.thread.shareresource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;

    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.intGenerator = generator;
        this.id = id;
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
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println(val + " is not even");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            e.execute(new EvenChecker(generator, i));
        }
        e.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}

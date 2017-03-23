package com.core.thread.blocked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class Interrupting {

    private static ExecutorService e = Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> f = e.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("Interrupting:" + runnable.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
//        SleepBlocked s = new SleepBlocked();
//        Thread t = new Thread(s);
//        t.start();
//        t.interrupt();
//        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with system.exit(0)");
        System.exit(0);

    }
}

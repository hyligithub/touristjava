package com.core.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class CriticalSection {
    static void
        testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService e = Executors.newCachedThreadPool();
        PairManipulator
                p1 = new PairManipulator(pm1),
                p2 = new PairManipulator(pm2);
        PairChecker
                pc1 = new PairChecker(pm1),
                pc2 = new PairChecker(pm2);
        e.execute(p1);
        e.execute(p2);
        e.execute(pc1);
        e.execute(pc2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("p1:" + p1 + "\np2:" + p2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pm1 = new PairManager1();
        PairManager pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}

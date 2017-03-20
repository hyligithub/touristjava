package com.core.thread.sync;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class PairManager1 extends PairManager {
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {

    public void increment() {
        Pair temp;
        synchronized (this) {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}


class PairManipulator implements Runnable {

    PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair:" + pm.getPair() +
                " checkCounter=" + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            try {
                pm.getPair().checkState();
            } catch (RuntimeException e) {
                System.out.println(pm.getClass().getSimpleName());
            }
        }
    }
}

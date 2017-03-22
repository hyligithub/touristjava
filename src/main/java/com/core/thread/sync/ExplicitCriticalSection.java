package com.core.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class ExplicitCriticalSection {

    public static void main(String[] args) {
        PairManager p1 = new ExplicitPairManager1();
        PairManager p2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(p1, p2);
    }
}

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        Pair temp;
        try {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}




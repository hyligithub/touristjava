package com.core.thread.shareresource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue;

    private Lock lock = new ReentrantLock();

    public int next() {
        try {
            lock.lock();
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}

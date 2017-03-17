package com.core.thread.shareresource;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int evenValue;

    public synchronized int next() {
        ++evenValue;
        Thread.yield();
        ++evenValue;
        return evenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

}

package com.core.thread.cancel;

import java.util.Random;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class Count {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean())
            Thread.yield();
        return count = ++temp;
    }

    public synchronized int value() {
        return count;
    }
}

package com.core.thread.atomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger ai = new AtomicInteger(0);

    public int getValue() {
        return ai.get();
    }

    public void evenIncrement() {
        ai.addAndGet(2);
    }


    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest ai = new AtomicIntegerTest();
        executorService.execute(ai);
        while (true) {
            int value = ai.getValue();
            if (value % 2 != 0) {
                System.out.println("value is not even:" + value);
                break;
            }
        }
    }
}

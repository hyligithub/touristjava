package com.core.thread.shareresource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class AttemptLocking {
    private Lock lock = new ReentrantLock();

    public void untimed() {
        boolean capture = false;
        try {
            capture = lock.tryLock();
            System.out.println("lock.tryLock() is " + capture);
        } finally {
            if (capture)
                lock.unlock();
        }
    }

    public void timed() {
        boolean capture = false;
        try {
            capture = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println("lock.try(2,s) is " + capture);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (capture)
                lock.unlock();
        }
    }


    public static void main(String[] args) {
        final AttemptLocking a = new AttemptLocking();
        a.untimed();
        a.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            public void run() {
                a.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        a.untimed();
        a.timed();
    }
}

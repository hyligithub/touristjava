package com.core.thread.varaint;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class ThreadMethod {
    private int countDown = 5;
    Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) return;
                            TimeUnit.MILLISECONDS.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                public String toString() {
                    return Thread.currentThread().getName() + "--" + countDown;
                }
            };
            t.start();
        }
    }
}

package com.core.thread.varaint;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class AnonymousInnerClass {
    private int countDown = 5;
    private Thread t;

    public AnonymousInnerClass(String name) {
//        t = new Thread(name);
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println(" interrutped");
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ":" + countDown;
            }
        };
        t.start();
    }
}

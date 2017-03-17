package com.core.thread.varaint;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class InnerClassThread {

    private int countDown = 5;
    public Inner inner;

    public InnerClassThread(String name) {
        inner = new Inner(name);
//        inner.start();
    }

    private class Inner extends Thread {

        public Inner(String name) {
            super(name);
            System.out.println(Thread.currentThread().getName());
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public String toString() {
            return Thread.currentThread().getName() + ":" + countDown;
        }
    }
}

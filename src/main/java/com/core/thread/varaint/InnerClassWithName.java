package com.core.thread.varaint;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class InnerClassWithName {
    private int countDown = 5;

    public InnerClassWithName(String name) {
        InnerClass i = new InnerClass(name);
    }

    class InnerClass implements Runnable {
        Thread t;

        public InnerClass(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("intterupted");
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ":" + countDown;
        }
    }
}

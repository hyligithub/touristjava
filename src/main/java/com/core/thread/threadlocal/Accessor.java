package com.core.thread.threadlocal;

/**
 * Created by lihuiyan on 2017/3/21.
 */
public class Accessor implements Runnable {
    private int id;

    public Accessor(int id) {
        this.id = id;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + "---" + ThreadLocalVariableHolder.get();
    }
}

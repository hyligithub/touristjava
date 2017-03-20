package com.core.thread.atomic;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class CircularSet {
    private int[] array;
    private int size;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % size;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < size; i++) {
            if (array[i] == val)
                return true;
        }
        return false;
    }
}

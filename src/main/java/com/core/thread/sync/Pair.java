package com.core.thread.sync;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class Pair {
    private int x, y;
    public Pair(){}
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public String toString() {
        return "x=" + x + ",y=" + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("pair value not equal:" + Pair.this);
        }
    }

    public void checkState() {
        if (x != y)
            throw new PairValuesNotEqualException();
    }
}

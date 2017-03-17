package com.core.thread.shareresource;

/**
 * Created by lihuiyan on 2017/3/17.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenvalue = 0;

    public int next() {
        ++currentEvenvalue;//danger
        ++currentEvenvalue;
        return currentEvenvalue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}

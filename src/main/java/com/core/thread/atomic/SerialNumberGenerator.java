package com.core.thread.atomic;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;//not thread-safe
    }
}

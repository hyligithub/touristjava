package com.core.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/20.
 */
public class SerialNumberChecher {
    private static final int SIZE = 10;
    private static CircularSet serails = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serails.contains(serial)) {
                    System.out.println("Duplicate :" + serial);
                    System.exit(0);
                }
                serails.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new SerialChecker());
        }
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("not duplicate serial");
            System.exit(0);
        }
    }
}

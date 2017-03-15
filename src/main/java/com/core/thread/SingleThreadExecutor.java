package com.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            e.execute(new Liftoff());
        }
        e.shutdown();
    }
}

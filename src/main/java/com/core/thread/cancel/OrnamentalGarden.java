package com.core.thread.cancel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            e.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        e.shutdown();
        if (!e.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("some tasks were not terminated");
        }
        System.out.println("Total:" + Entrance.getTotalCount());
        System.out.println("Sum of Entrances:" + Entrance.sumEntrances());
    }
}

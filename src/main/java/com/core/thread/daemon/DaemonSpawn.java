package com.core.thread.daemon;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}

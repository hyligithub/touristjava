package com.core.thread.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}

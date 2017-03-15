package com.core.thread.daemon;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class DaemonDontRunFinally {

    public static void main(String[] args) {
        Thread a = new Thread(new DaemonFinally());
        a.setDaemon(true);
        a.start();
        System.out.println("DaemonFinally .....");
    }
}

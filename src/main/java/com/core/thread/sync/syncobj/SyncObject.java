package com.core.thread.sync.syncobj;

/**
 * Created by lihuiyan on 2017/3/21.
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread() {
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}

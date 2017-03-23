package com.core.thread.blocked;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lihuiyan on 2017/3/22.
 */
public class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("waiting for read");
            in.read();
        } catch (IOException i) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from I/O");
            } else
                throw new RuntimeException();
        }
        System.out.println("Exit from IOBlocked.run()");
    }
}

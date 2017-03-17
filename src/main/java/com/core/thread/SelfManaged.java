package com.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/16.
 * 自管理的线程，因为是实现接口，所以可扩展性高
 * 构造函数中启动线程的做法不好
 */
public class SelfManaged implements Runnable {

    private Thread thread = new Thread(this);
    private int countDown = 5;

    public String toString() {
        return Thread.currentThread().getName() + "--" + countDown;
    }

    public SelfManaged() {
        thread.start();
    }

    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
//            executorService.execute(new SelfManaged());
            new SelfManaged();
        }
    }
}

package com.core.thread.varaint;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class MyThread extends Thread {
    public MyThread(String name){
        super(name);
        start();
    }

    public void run(){
        System.out.println("mythread started");
    }
}

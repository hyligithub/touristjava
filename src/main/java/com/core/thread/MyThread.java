package com.core.thread;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class MyThread {
    public static void main(String[] args){
//        Liftoff liftoff = new Liftoff();
//        liftoff.run();
//        Thread a = new Thread(new Liftoff());
//        a.start();

        for(int i =0;i<5;i++){
            new Thread(new Liftoff()).start();
        }
        System.out.println("waiting for liftoff");
    }
}

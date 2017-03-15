package com.core.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class CacheThreadPool {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new Liftoff());
        }
        executorService.shutdown();
    }
}

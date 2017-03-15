package com.core.thread;

import java.util.concurrent.Callable;

/**
 * Created by lihuiyan on 2017/3/15.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public String call() throws Exception {
        return "Task with result's id = " + id;
    }
}

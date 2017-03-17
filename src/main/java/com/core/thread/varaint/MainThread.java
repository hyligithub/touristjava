package com.core.thread.varaint;

/**
 * Created by lihuiyan on 2017/3/16.
 */
public class MainThread {
    public static void main(String[] args) {
        AnonymousInnerClass a = new AnonymousInnerClass("anonymous");
        InnerClassThread innerClassThread = new InnerClassThread("innerThread");
        MyThread myThread = new MyThread("mythread");
        InnerClassWithName icw = new InnerClassWithName("inner class with name");
        ThreadMethod threadMethod = new ThreadMethod("ThreadMethod");
        threadMethod.runTask();

    }
}

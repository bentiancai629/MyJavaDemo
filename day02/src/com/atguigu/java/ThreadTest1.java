package com.atguigu.java;

/**
 * 多线程创建的方式
 * 1. 实现runable接口
 * 2. 实现类实现抽象方法run();
 * 3. 创建实现类的对象
 * 4. 此对象作为参数传递到thread类的构造器中
 * 通过thread类对象调用start
 */

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);

        // 启用线程
        // 调用线程的run方法
        t1.start();
        t2.start();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }
}

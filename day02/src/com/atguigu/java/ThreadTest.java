package com.atguigu.java;

/**
 * 多线程创建的方式
 * 1. 继承Thread类 重写run方法 调用实例的start()
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        3. 实例化
        MyThread t1 = new MyThread();
//        4. 调用start方法
        t1.start(); // 多线程

//        问题1：不能通过直接调用run方法启动多线程
//        t1.run(); // 只有主线程

//        问题2: 再启动一个线程
//        t1.start(); // 只能start一次

        MyThread t2 = new MyThread();
        t2.start(); // 多线程


        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }

        System.out.println("hello");
    }
}

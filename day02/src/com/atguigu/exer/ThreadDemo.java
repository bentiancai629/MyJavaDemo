package com.atguigu.exer;

/**
 * 练习：两个线程分别遍历奇偶数
 *
 * @author Eric Ni
 * @create 2020-05-31 17:18
 */
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread2.start();
        System.out.println(Thread.currentThread().getName() + "--" + "over");

        // 创建thread匿名子类
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "--" + i);
                    }
                }
            }
        }.start();

    }

}


class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }
}

package com.atguigu.java2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Eric Ni
 * @create 2020-05-31 21:07
 * <p>
 * 解决线程安全问题 lock锁
 */

class Window implements Runnable {
    private int ticket = 100;

    //    1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
//                2. 调用lock方法
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号：" + ticket);
                    ticket--;
                } else {
                    return;
                }
            } finally {
//                3. 解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");

        t1.start();
        t2.start();
        t3.start();

    }

}

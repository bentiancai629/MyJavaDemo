package com.atguigu.java1;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:57
 * <p>
 * 使用runnable接口实现
 * 可以多继承接口 继承其他类
 * 天然共享实例数据
 * <p>
 * 解决线程不安全： 锁住线程，让其他线程不能进来
 * <p>
 * <p>
 *
 * 方法一: 同步代码块
 * syncchronized(同步监视器)
 *      共用通同一把锁
 *
 *
 * 方法二: 同步方法
 * 如果需要同步代码完整在一个方法中
 */
public class WindowTest1 {
    public static void main(String[] args) {
        // 只有1个对象
        Window1 w = new Window1();

        // 3个线程公用w实例
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable {
    private int ticket = 100;
    Object o = new Object();

    @Override
    public void run() {

        while (true) {

            // 同步代码块 锁 任何一个类对象

            synchronized (Window1.class) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

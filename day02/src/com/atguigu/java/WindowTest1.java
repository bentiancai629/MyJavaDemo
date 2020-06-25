package com.atguigu.java;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:57
 * <p>
 * 使用runnable接口实现
 * 可以多继承接口 继承其他类
 * 天然共享实例数据
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

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

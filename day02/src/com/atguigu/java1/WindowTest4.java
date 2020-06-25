package com.atguigu.java1;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:57
 * <p>
 * 使用同步方法操作继承类的多线程
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4("窗口1：");
        Window4 t2 = new Window4("窗口2：");
        Window4 t3 = new Window4("窗口3：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public Window4(String name) {
        super(name);
        this.ticket = ticket;
    }

    public static synchronized void show() { // 同步监视器 Window4.class
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号：" + ticket);
            ticket--;
        }
    }
}

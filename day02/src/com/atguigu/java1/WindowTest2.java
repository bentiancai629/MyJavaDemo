package com.atguigu.java1;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:57
 * <p>
 * 使用继承thread类实现
 * 因为单继承 class不能继承别的类
 * 不容易公用对象 不能共享数据
 *
 * 谨慎用this当同步监视器
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2("窗口1：");
        Window2 t2 = new Window2("窗口2：");
        Window2 t3 = new Window2("窗口3：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Window2.class) {
                if (ticket > 0) {


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 卖票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }

    public Window2(String name) {
        super(name);
        this.ticket = ticket;
    }
}

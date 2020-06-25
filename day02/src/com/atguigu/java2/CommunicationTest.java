package com.atguigu.java2;

/**
 * @author Eric Ni
 * @create 2020-05-31 21:32
 */
class Number implements Runnable {

    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
            synchronized (obj) {// IllegalMonitorStateException
                obj.notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        //  wait使线程阻塞
                        // wait会释放锁 和sleep不一样
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1：");
        t2.setName("线程2：");

        t1.start();
        t2.start();
    }
}

package com.atguigu.java;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:23
 * <p>
 * <p>
 * start()
 * run()
 * currentThread()
 * setName()
 * getName()
 * yield()
 * john()
 * sleep()
 * isAlive()
 * <p>
 * 线程的优先级
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("Thread1: ");
        helloThread.setName("线程1: ");
        helloThread.setPriority(3);
        helloThread.start();

        Thread.currentThread().setName("主线程: ");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 优先级: " + Thread.currentThread().getPriority() + "-- " + i);
            }
            if (i % 2 == 0) {
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 优先级: " + Thread.currentThread().getPriority() + "-- " + i);
//                try {
//                    sleep(100);
////                    System.out.println(isAlive());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
//            if (i % 4 == 0) {
//                this.yield();
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Eric Ni
 * @create 2020-05-31 22:19
 */

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass().getName());

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(12);

        service.execute(new NumberThread()); // 适合Runnable
        service.execute(new NumberThread1()); // 适合Runnable
        service.shutdown();

//        service.submit(); // 适合callable
    }
}

package com.atguigu.java2;

/**
 * @author Eric Ni
 * @create 2020-05-31 20:46
 */
public class BankTest {
    public static void main(String[] args) {

    }
}

/**
 * 容易阻塞出现new多个实例
 */
class Bank {
    private static Bank instance = null;

    public static Bank getInstance() {
//        // 方法一：
//        synchronized (Bank.class) {
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//        }

//        方法二：
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;

    }
}

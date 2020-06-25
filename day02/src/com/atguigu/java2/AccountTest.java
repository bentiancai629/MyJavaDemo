package com.atguigu.java2;

/**
 * @author Eric Ni
 * @create 2020-05-31 21:19
 */

class Account1 {
    private double balance;

    public Account1(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance += amt;
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account1 account;

    public Customer(Account1 account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account1 account = new Account1(0);
        Customer c1 = new Customer(account); // 用户共用同一个账号
        Customer c2 = new Customer(account);

        c1.setName("甲方");
        c2.setName("乙方");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();


    }
}

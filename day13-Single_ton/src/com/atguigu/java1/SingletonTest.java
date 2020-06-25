package com.atguigu.java1;

public class SingletonTest {
    public static void main(String[] args) {
        Bank1 bank1 = Bank1.getInstace();
        Bank1 bank2 = Bank1.getInstace();
        System.out.println(bank1==bank2);

        Bank2.instance = null;
        Bank2 bank3 = Bank2.instance;
        System.out.println(bank3);

    }
}

class Bank1 {

    private Bank1() {
    }

    public static  Bank1 instance = new Bank1();

    public static Bank1 getInstace() {
        System.out.println("getInstace方法");
        return instance;
    }

    static {
        System.out.println("static代码块");
        instance = new Bank1();
    }
}

class Order1 {
    private Order1() {
    }

    private static Order1 instance = null;

    public static Order1 getInstance() {
        if (instance == null) {
            instance = new Order1();
        }

        return instance;
    }
}


class Bank2 {

    private Bank2() {
    }

    public static Bank2 instance = new Bank2();

    public static Bank2 getInstace() {
        System.out.println("getInstace方法");
        return instance;
    }
}
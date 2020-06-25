package com.atguigu.exer2;

public class AccountTest {
    public static void main(String[] args) {
        Account acat = new Account(1122,20000,0.045);

        acat.withdraw(30000);
        System.out.println(acat.getBalance());
        acat.withdraw(2500);
        System.out.println(acat.getBalance());
        acat.deposit(3000);
        System.out.println(acat.getBalance());

        System.out.println("您的月利率："+(acat.getAnnualInterestRate() *100) + "%");
        acat.withdraw(20500);
        System.out.println(acat.getBalance());
        acat.withdraw(25000);
        System.out.println(acat.getBalance());
        acat.withdraw(2500);
        System.out.println(acat.getBalance());
    }
}

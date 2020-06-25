package com.atguigu.exer2;

public class CheckAccount extends Account {

    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
//            getBalance() -= amount;
            // 方式1
//            setBalance(getBalance() - amount);
            // 方法2
            super.withdraw(amount);
        } else if (overdraft >= amount - getBalance()) {
            setBalance(0);
            overdraft -= (amount - getBalance());
        }else{
            System.out.println("超过透支额度");
        }
    }
}

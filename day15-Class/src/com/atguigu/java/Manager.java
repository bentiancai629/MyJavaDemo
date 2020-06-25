package com.atguigu.java;

public class Manager extends Employee {
    private double bonous;

    public Manager(double bonous) {
        this.bonous = bonous;
    }

    public Manager(String name, int id, double salary, double bonous) {
        super(name, id, salary);
        this.bonous = bonous;
    }

    @Override
    void work() {
        System.out.println("管理员工");
    }
}

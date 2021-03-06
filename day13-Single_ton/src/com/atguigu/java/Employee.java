package com.atguigu.java;

public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;


    public abstract double earnings();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }
}


package com.atguigu.exer2;

public class HourlyEmployee extends Employee {

    private int wage;
    private int hour;

    @Override
    public double earnings() {
        return 0;
    }

    public HourlyEmployee(String name, int number, MyDate birthday,int wage,int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    public String toString(){
        return "HourlyEmployee[" + super.toString()+"]";
    }
}

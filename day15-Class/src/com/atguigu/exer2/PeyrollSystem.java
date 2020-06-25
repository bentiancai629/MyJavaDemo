package com.atguigu.exer2;

import java.util.Calendar;

public class PeyrollSystem {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int m = calendar.get(Calendar.MONTH);
        System.out.println(m);

        Employee[] emps = new Employee[2];
        Employee[] emps2 = new Employee[3];

        emps[0] =new SalariedEmployee("jack",1002,new MyDate(1992,6,29));
        emps[1] =new HourlyEmployee("jim",1003,new MyDate(1993,7,29),2,2);

        for (int i =0;i<emps.length;i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资："+salary);
        }

    }
}

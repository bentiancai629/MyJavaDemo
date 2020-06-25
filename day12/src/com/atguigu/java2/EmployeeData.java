package com.atguigu.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Ni
 * @create 2020-06-25 14:32
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马云", 44, 6000.23));
        list.add(new Employee(1002, "马化腾", 42, 6500.33));
        list.add(new Employee(1003, "刘强东", 34, 4000.03));
        list.add(new Employee(1004, "黄光裕", 42, 2300.54));
        list.add(new Employee(1005, "任正非", 66, 7000.44));
        list.add(new Employee(1006, "扎克伯格", 22, 8900.30));

        return list;
    }

}

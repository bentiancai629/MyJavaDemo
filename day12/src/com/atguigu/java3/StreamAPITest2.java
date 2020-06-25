package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Eric Ni
 * @create 2020-06-25 15:02
 */
public class StreamAPITest2 {

    // allMatch
    // AnyMatch
    // noneMatch
    // findFirst
    // count
    // Max


    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

    }

}

package com.atguigu.java;

import day13.java1.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Eric Ni
 * @create 2020-05-31 13:09
 */
public class DaoTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
       List<Customer> list = dao1.getForList(1);


       StudentDAO dao2 = new StudentDAO();
       dao2.add(new Student());
       List<Student> list1 = dao2.getForList(1);

    }
}

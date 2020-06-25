package com.atguigu.java1;

public class ToStringTest {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Eric", 11);
        Customer customer2 = new Customer("Eric", 11);
        System.out.println(customer1.toString()); // day13.java1.Customer@4554617c
        System.out.println(customer2.toString()); // day13.java1.Customer@74a14482
        System.out.println(customer2); // day13.java1.Customer@74a14482
    }
}

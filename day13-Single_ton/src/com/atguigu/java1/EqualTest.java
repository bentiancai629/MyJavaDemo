package com.atguigu.java1;

public class EqualTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10;
        char c = 10;


        System.out.println(i == i);
        System.out.println(i == d);
        System.out.println(i == c);

        boolean b= false;
//        System.out.println(i == b);


        Customer customer1 = new Customer("j", 321);
        Customer customer2 = new Customer("j", 321);

        System.out.println(customer1 == customer2); //false 地址不同
        System.out.println("customer1重写equals "+customer1.equals(customer2) ); //false 对象的引用地址不同

        String str1 = new String("cu1");
        String str2 = new String("cu1");
        System.out.println(str1==str2);  // false  两个对象，引用地址不同
        System.out.println(str1.equals(str2));  // true  两个对象，字符串常量池结果相同

        // equal只能用在引用数据类型

    }
}

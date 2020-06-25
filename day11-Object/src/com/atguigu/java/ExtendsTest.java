package com.atguigu.java;

public class ExtendsTest {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setAge(1);


        // 子类获的父类的private属性，但是不能直接调用
        Student s1 = new Student();
        s1.setAge(1);
        System.out.println(s1);
        s1.breath();

        Object object;
    }

}

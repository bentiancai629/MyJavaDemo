package com.atguigu.java4;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        // **************************
        Person p2 = new Man();
        p2.eat();


        Person p3= new Weman();
        p3.eat();
    }
}

package com.atguigu.java;

public class AbstractTest {
    public static void main(String[] args) {

    }
}


abstract class Person {
    String name;
    int age;

    abstract void breath();

    public void eat() {
        System.out.println("人吃饭");
    }

    public void walk() {
        System.out.println("人走路");
    }

}

class Student extends Person {

    @Override
    void breath() {
        System.out.println("学生呼吸");
    }
    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
    @Override
    public void walk() {
        System.out.println("学生走路");
    }
}
package com.atguigu.java;

/**
 * 匿名子类
 */
public class PersonTest {
    public static void main(String[] args) {
//        method(new Student()); // 匿名对象

        // 创建匿名类对象
        Person p = new Person() {
            @Override
            void breath() {
                System.out.println("好好呼吸");
            }

            @Override
            public void eat() {
                System.out.println("好好吃饭");
            }
        };

        method1(p);

        method1(new Person() {
            @Override
            void breath() {
                System.out.println("吸空气");
            }
        });
    }

    public static void method1(Person p){
        p.eat();
        p.breath();
    }
    public static void method(Student s){

    }

}

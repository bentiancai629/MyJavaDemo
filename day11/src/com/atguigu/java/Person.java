package com.atguigu.java;

/**
 * @author Eric Ni
 * @create 2020-06-22 22:46
 */
public class Person {
    public static final long serialVersionUID = 42423142314213L;
    private String name;


    public int age;

    public Person() {
        System.out.println("空参构造器");
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("我是人");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }
}

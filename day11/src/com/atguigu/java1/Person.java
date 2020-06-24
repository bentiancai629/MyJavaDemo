package com.atguigu.java1;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author Eric Ni
 * @create 2020-06-22 22:46
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    public static final long serialVersionUID = 42423142314213L;
    private String name;
    int age;
    public int id;

    public Person() {
        System.out.println("Person空参构造器");
    }

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String display(
            String interests, int age) throws NullPointerException, ClassCastException {
        return String.format("%s%d", interests, age);
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void showDesc(){
        System.out.println("我是一个静态的方法");
    }

}

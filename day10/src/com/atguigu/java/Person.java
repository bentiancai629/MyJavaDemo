package com.atguigu.java;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 1. 需要实现Serializable接口
 * 2. 提供全局常量serialVersionUID
 * 3. 除了Person类实现Serializable接口，还必须保证内部属性也是可序列化的
 * 4. static和transit不能序列化
 *
 * @author Eric Ni
 * @create 2020-06-21 9:24
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 42423142314213L;
    String name;

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

    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

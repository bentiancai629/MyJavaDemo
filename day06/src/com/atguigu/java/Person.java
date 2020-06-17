package com.atguigu.java;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Eric Ni
 * @create 2020-06-14 14:53
 */
public class Person implements Comparable {
    String name;
    Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Person person = (Person) o;
            return Objects.equals(this.name, person.name) && Objects.equals(this.age, person.age);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o1) {
        if (o1 instanceof Person) {
            Person person = (Person) o1;
//            return -this.name.compareTo(person.name);
            int compare = this.name.compareTo(person.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, person.age);
            }
        } else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }

}

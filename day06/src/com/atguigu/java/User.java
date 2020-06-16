package com.atguigu.java;

import java.util.Objects;

/**
 * @author Eric Ni
 * @create 2020-06-14 14:53
 */
public class User {
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

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            User person = (User)o;
            return Objects.equals(this.name, person.name) && Objects.equals(this.age, person.age);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

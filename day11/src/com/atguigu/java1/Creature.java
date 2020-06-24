package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author Eric Ni
 * @create 2020-06-24 13:58
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    public void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}

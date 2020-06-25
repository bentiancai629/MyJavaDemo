package com.atguigu.java8;

public class InterFaceTest {
    public static void main(String[] args) {
        System.out.println("compareA:北京");
    }
}

interface CompareA {
    public static void a() {
        System.out.println();
    }

    default void b() {

    }

    default void c() {
    }

}

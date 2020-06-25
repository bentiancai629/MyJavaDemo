package com.atguigu.java1;

import org.junit.Test;

public class JunitTest {

    @Test
    public void Test(){
       Object o1 = true? new Integer(1):new Double(2.0);
        System.out.println(o1);
    }

    @Test
    public void test2(){
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        System.out.println( m == n);

        Integer x = 128; // new 了一个x的cache
        Integer y = 127;
        System.out.println(x==y);
    }
}

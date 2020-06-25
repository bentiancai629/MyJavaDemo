package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式
 *
 * @author Eric Ni
 * @create 2020-06-25 10:35
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京");
            }
        };
        r1.run();

        System.out.println("*********************");

        Runnable r2 =  () ->System.out.println("我爱北京");
        r2.run();
    }


    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 13);
        System.out.println(compare1);

        System.out.println("*********************");

        Comparator<Integer> com2 = (o1,o2)-> Integer.compare(o1,o2);
        int compare2 = com2.compare(31,32);
        System.out.println(compare2);

        System.out.println("*********************");

        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(31,32);
        System.out.println(compare3);
    }
}

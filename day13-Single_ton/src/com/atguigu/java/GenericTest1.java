package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Ni
 * @create 2020-05-31 10:08
 */
public class GenericTest1 {

    @Test
    public void test1() {
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        Order<String> order1 = new Order<>();
        order1.setOrderT("1");
//      order1.setOrderT(1);

        System.out.println(order1.toString());
    }


    @Test
    public void test2() {
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderId(123);
//        subOrder.setOrderId("123");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();
    }

    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        // 泛型方法调用时 指明类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}

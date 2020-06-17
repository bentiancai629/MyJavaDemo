package com.atguigu.exer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Ni
 * @Project: MyJavaDemo
 * @Package com.atguigu.exer
 * @date 2020-06-14 23:00
 */
public class ListExer {
    @Test
    public void test1(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    public void updateList(List list){
        list.remove(2);
        list.remove(new Integer(1));
    }
}

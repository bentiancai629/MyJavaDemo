package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Eric Ni
 * @create 2020-06-14 15:08
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tom");
        coll.add(false);

        for (Object obj: coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

//        普通for循环
//        for (int i = 0; i<arr.length;i++){
//            arr[i]="GG";
//        }

        // 增强for循环
        for (String s: arr){
            s = "GG";
        }

        for (int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}

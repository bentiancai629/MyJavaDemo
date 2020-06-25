package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Eric Ni
 * @create 2020-05-31 10:08
 */
public class GenericTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add("tom"); // ClassCastException

        for (Object score : list) {
            int s = (Integer) score;
            System.out.println(s);
        }
    }

    // 指定元素类型 编译检查
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
//        list.add("tom"); // ClassCastException

        // 方法1
//        for (Integer score : list) {
//            int s = score;
//            System.out.println(s);
//        }

        // 方法2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int score = iterator.next();
            System.out.println(score);
        }
    }

    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("tom",1);
        map.put("jack",2);
        map.put("rose",3);

//        map.put(123,"abc");
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();

            System.out.println(key +"-" +value);
        }
    }
}

package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Eric Ni
 * @create 2020-06-16 23:44
 */
public class TreeMapTest {

    // key必须是同一个类创建的对象
    // 要按照key进行排序 自然排序 定制排序
    @Test
    public void test1() {

        TreeMap treeMap = new TreeMap();
        Person u1 = new Person("TOM", 11);
        Person u2 = new Person("JACK", 13);
        Person u3 = new Person("ROSE", 12);
        Person u4 = new Person("JACKS", 14);

        treeMap.put(u1, 98);
        treeMap.put(u2, 97);
        treeMap.put(u3, 96);
        treeMap.put(u4, 99);

        Set keySet = treeMap.keySet();
        Iterator iterator2 = keySet.iterator();

        while (iterator2.hasNext()) {
            Object obj = iterator2.next();

            // entrySet中的元素是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    // 定制排序
    @Test
    public void test2() {

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
               throw new RuntimeException("类型不匹配");
            }
        });

        Person u1 = new Person("TOM", 11);
        Person u2 = new Person("JACK", 13);
        Person u3 = new Person("ROSE", 12);
        Person u4 = new Person("JACKS", 14);

        treeMap.put(u1, 98);
        treeMap.put(u2, 97);
        treeMap.put(u3, 96);
        treeMap.put(u4, 99);

        Set keySet = treeMap.keySet();
        Iterator iterator2 = keySet.iterator();

        while (iterator2.hasNext()) {
            Object obj = iterator2.next();

            // entrySet中的元素是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }
}

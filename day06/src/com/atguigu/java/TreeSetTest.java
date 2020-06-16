package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.util.*;

/**
 * @author Eric Ni
 * @create 2020-06-15 23:52
 */
public class TreeSetTest {

    /**
     * 向treeSet添加一个类必须是同一个类
     * <p>
     * 自然排序中比较对象是否相同的标准 compareTo()返回0 不再是equals()
     */
    @Test
    public void test1() {
        Set set = new TreeSet();
//        set.add(123);
//        set.add(456);
//        set.add("ABC");
//        set.add("CDE");
//        set.add(789);


        set.add(new Person("Tom", 10));
        set.add(new Person("Tall", 11));
        set.add(new Person("Toms", 12));
        set.add(new Person("Tim", 13));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.age, u2.age);
                } else {
                    throw new RuntimeException("类型不匹配");
                }

            }
        };

        Set set = new TreeSet();
        set.add(new Person("Tom", 10));
        set.add(new Person("Tall", 11));
        set.add(new Person("Toms", 12));
        set.add(new Person("Tim", 13));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}

package com.atguigu.java;

import day12.java4.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Ni
 * @create 2020-05-31 13:25
 * <p>
 * <p>
 * // 父子类的泛型父子类关系依旧
 * // 元素中泛型父子类不继承 两个类是并列的
 * <p>
 * 泛型通配符使用
 */
public class GenerticTest2 {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
//        list1 = list2;

        show(list1);
//        show(list2);

        show1(list1);
        show1(list2);
    }


    public void show(List<Object> list) {
    }

    public void show1(List<?> list) {
    }

    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

        list.add(null);
        Object o = list.get(0);
        System.out.println(o);
    }

    /**
     * 有限制条件的通配符
     */
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5; // object大于 person

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        list2.add(new Person());
        list2.add(new Student());
//        list2.add(new Object());
    }


}

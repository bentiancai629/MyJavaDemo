package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 1.对象的存储：①数组（基本数据类型  & 引用数据类型）  ②集合（引用数据类型）
 *     >数组存储数据的弊端：长度一旦初始化以后，就不可变；真正给数组元素赋值的个数没有现成的方法可用。
 * 2.集合框架
 * Collection接口 ：方法：①add(Object obj),addAll(Collection coll),size(),clear(),isEmpty();
 * 				    ②remove(Object obj),removeAll(Collection coll),retainAll(Collection coll),equals(Object obj),contains(Object obj)
 * 				        containsAll(Collection coll),hashCode()
 * 				    ③ iterator(),toArray();
 *
 * 				    |------List接口：存储有序的，可以重复的元素.---相当于“动态”数组
 * 			>新增的方法：删除remove(int index) 修改set(int index,Object obj) 获取get(int index)插入add(int index,Object obj)
 * 			>添加进List集合中的元素（或对象）所在的类一定要重写equals()方法
 *  *     				|------ArrayList（主要的实现类）
 * 					|------LinkedList（更适用于频繁的插入、删除操作）
 * 					|------Vector（古老的实现类、线程安全的，但效率要低于ArrayList）
 *
 *
 * @author Eric Ni
 * @create 2020-06-14 14:52
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(456);
        Person jerry = new Person("Jerry", 20);
        coll.add(jerry);
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(jerry));
        System.out.println(coll.contains(new Person("Jerry", 20)));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(789);
        Person jerry = new Person("Jerry", 20);
        coll.add(jerry);
        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);
        List<Integer> list = Arrays.asList(789, 456);
        coll.removeAll(list);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(789);
        Person jerry = new Person("Jerry", 20);
        coll.add(jerry);
        List<Integer> list = Arrays.asList(123, 456, 789);
        coll.retainAll(list);
        System.out.println(coll);
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tom");
        coll.add(false);
        Collection coll2 = new ArrayList();
        coll2.add("Tom");
        coll2.add(false);
        coll2.add(123);
        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tom");
        coll.add(false);
        System.out.println(coll.hashCode());
        Object[] array = coll.toArray();

        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }

        List<String> list = Arrays.asList("AA", "BB", "CC");
        System.out.println(list);
        List<int[]> list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1);
        List list2 = Arrays.asList(123, 456);
        System.out.println(list2);
    }
}

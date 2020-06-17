package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collection接口 ：单列集合，用来存储一个一个的对象
 * <p>
 * List接口 存储有序、可重复的数据
 * |-----ArrayList: 普通链表作为list的主要实现类、线程不安全，效率高，底层Object[]数据结构 elementData存储
 * |-----LinkedList: 对于频繁插入删除效率比arrayList高，底层使用双向链表
 * |-----vector: 线程安全 效率低
 * <p>
 * 源码分析 JDK7
 * ArrayList arrayList = new ArrayList<>(); // 底层创建长度10的Object[]数组elementData
 * list.add(123); // elementData[0] = new Integer(123);
 * ...
 * list.add(456); //数组容量不够 扩容grow
 * 默认扩容1.5倍 同时复制原有的数组数据到新数组中
 * <p>
 * 建议使用带参数的构造器
 * <p>
 * JDK8中ArrayList的变化
 * ArrayList arrayList = new ArrayList<>(); // 底层创建Object[]数组elementData{}
 * list.add(123); // 创建了数组， elementData[0] = new Integer(123);
 * <p>
 * 小结： jdk7类似单例饿汉式 jdk8类似懒汉式
 * <p>
 * Map接口
 * |-----HashMap:Map的主要实现类
 * |-----LinkedHashMap:使用链表维护添加进Map中的顺序。故遍历Map时，是按添加的顺序遍历的。
 * |-----TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求：key必须是同一个类的对象！
 * 针对key：自然排序   vs 定制排序
 * |-----Hashtable:古老的实现类，线程安全，不建议使用。
 * |----Properties:常用来处理属性文件。键和值都为String类型的
 *
 * @author Eric Ni
 * @create 2020-06-14 15:16
 */
public class ListTest {
    @Test
    public void test2() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Tom", 20));
        System.out.println(arrayList);

        int index = arrayList.indexOf("AA");
        System.out.println(index);

        int i = arrayList.lastIndexOf(456);
        System.out.println(i);

        Object obj = arrayList.remove(1);
        System.out.println(obj);

        arrayList.set(1,"CC");
        System.out.println(arrayList);

        List subList = arrayList.subList(1, 3);
        System.out.println(subList);

    }

    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new Person("Tom", 20));
        System.out.println(arrayList);

        arrayList.add(3,"BB");
        System.out.println(arrayList);

        List<Integer> list = Arrays.asList(123, 445);

        arrayList.addAll(1,list);
        arrayList.add(1,list);
        System.out.println(arrayList);

        System.out.println(arrayList.get(2));

    }
}

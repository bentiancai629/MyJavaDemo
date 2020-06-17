package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  Collection接口 ：单列集合，用来存储一个一个的对象
 *      |----Set接口 无序、不可重复的数据
 *          |-----HashSet: Set主要实现类，线程不安全，可以存储Null值
 *              |-----LinkedHashSet: HashSet子类，遍历其内部数据时候，可以按照其内部数据添加
 *          |-----TreeSet: 可以按照添加对象的属性进行排序
 *
 *  1. Set接口没有额外的方法 都是继承于collection
 *
 *
 * @author Eric Ni
 * @date 2020-06-14 23:08
 */
public class SetTest {

    /**
     *
     * Set 无序和不可重复
     *
     * 1. 无序性：不等于随机性。底层数据并非按照数组索引的顺序添加，而是根据hash值顺序添加
     *
     *
     * 2. 不可重复性：通过equals() 返回true 判断是否重复
     *
     *  添加元素的过程，以HashSet为例
     *
     *
     */
    @Test
    public void test1(){
        Set hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("aa");
        hashSet.add("cc");
        hashSet.add(new User("Tom", 123)); // 通过equals() 返回true 判断是否重复
        hashSet.add(new User("Tom", 123));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(hashSet);


    }
}

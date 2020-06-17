package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.*;

/**
 * |------双列数据， 存储key-value值数据
 * |---HashMap： map的主要实现类 线程不安全 效率高，存储null的key value
 * |-- LinkedHashMap：保证遍历元素时候 保证添加的顺序，在原有hashmap中添加了指针，双向链表
 * |---TreeMap：保证按照添加的顺序，实现排序遍历
 * 底层红黑树
 * |---Hashtable：古老实现类 线程安全，效率低，不能存储null
 * |---properties：key value都是string类型
 * <p>
 * <p>
 * 二: Map的理解
 * Map中的key： 无序 不可重复的set结合, key所在的类要重写equals()和hashcode()
 * Map中的value： 无序 可重复的collection存储所有value
 * <p>
 * 1个key-value组成一个entry对象
 * Map中的entry是无序 不可重复的set存储所有entry
 * <p>
 * <p>
 * 三： HashMap底层原理 jdk7为例
 * HashMap map = new HashMap()
 * 实例化以后创建长度16的一维数组Entry[] table
 * ...多次put
 * map.put(key1,value1)
 * 首先调用key1所在类的hashcode计算key1值，此哈希值经过计算得到在entry数组中的存储位置
 * 如果此位置数据为空，则key1-value1添加成功  --情况1
 * 如果此位置数据不为空，此位置上存储1个或者多个数据(链表形式存在)比较key1和已经存在的数据的哈希值：
 * 如果key1值和某一个数据的哈希值不同，则key1-value1添加成功  --情况2
 * 如果key1值和某一个数据的哈希值(key2-value2)相同，则调用key1所在类的equals()方法，比较：
 * 如果equals返回false，则key1-value1添加成功  --情况3
 * 如果equals返回true，则value1替换value2
 * <p>
 * 补充情况2和情况3：key1-value1和原来数据以链表方式存储
 * <p>
 * 不断添加的过程，涉及到扩容，超出临界值(且要存放的位置非空)默认扩容是2倍，并将原来的数据复制过来
 * <p>
 * jdk8
 * 1. new HashMap()没有创建底层长度16的数组
 * 2. 底层数组是 node[]，非entry
 * 3. 首次调用才创建长度16的数组
 * 4. jdk7底层只有 数组+链表，
 * jdk8底层是   数组+链表+红黑树
 * 当数组索引位置上的元素以链表形式存在数据个数超过8，且当前数组长度>64，
 * 此时索引位置上的所有数据改为使用红黑树存储
 *
 * @author Eric Ni
 * @create 2020-06-16 21:26
 */
public class MapTest {

    @Test
    public void test6() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(25, 123);
        map.put("BB", 56);

        //遍历所有key集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历素有value
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }

        //遍历所有key-value
//        方式一:
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();

            // entrySet中的元素是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

//        方式二:
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();

        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "--->" +value);

        }


    }

    @Test
    public void test1() {
        Map map1 = new HashMap();
        map1.put(null, null);

        Map map2 = new Hashtable();
        map2.put(null, null);
    }
}

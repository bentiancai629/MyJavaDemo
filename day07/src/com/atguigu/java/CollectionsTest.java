package com.atguigu.java;

import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections: 操作Collection和Map的工具类
 *
 * @author Eric Ni
 * @create 2020-06-17 0:03
 */
public class CollectionsTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(13);
        list.add(62);
        list.add(23);
        list.add(23);
        list.add(54);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        // 线程安全
        List list1 = Collections.synchronizedList(list);
        

//        Collections.reverse(list); // 反转
//        Collections.shuffle(list); // 随机排序
//        Collections.sort(list); // 自然升序
//        Collections.swap(list,1,2); // 对换

//        Object max = Collections.max(list); // 最大值
//        Object max = Collections.max(list,Comparator); // 最大值
//        System.out.println(max);


//        Object min = Collections.min(list); // 最小值
//        Object min = Collections.min(list,Comparator); // 最小值

//        System.out.println(min);

//        int frequency =  Collections.frequency(list,23); // 频率
//        System.out.println(frequency);


        System.out.println(list);
    }
}

package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Eric Ni
 * @create 2020-06-15 23:52
 */
public class SetTest {

    @Test
    public void test2(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("ABC");
        set.add(789);

        Iterator iterator = set.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
    }
}

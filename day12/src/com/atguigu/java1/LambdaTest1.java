package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式
 *
 * 1.举例：(o1,o2)-> Integer.compare(o1,o2);
 * 2.格式：
 *      -> :Lambda操作符 或 箭头操作符
 *      ->左边 :lambda体 (其实就是重写的抽象方法的形参列表)
 *      ->右边 :lambda体 (其实就是重写的抽象方法的方法体)
 *
 *
 * 3. Lambda表达式的使用: 6种情况
 * 4.  Lambda表达式的本质：作为函数式接口的实例
 *
 * 5. 如果一个接口中只声明了一个抽象方法，就是函数式接口
 *
 *
 * @author Eric Ni
 * @create 2020-06-25 10:35
 */
public class LambdaTest1 {
    @Test
    public void test1(){
        // 匿名实现类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京");
            }
        };
        r1.run();

        System.out.println("*********************");

        Runnable r2 =  () -> {
            System.out.println("我爱北京");
        };
        r2.run();
    }


    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("区别是什么");
        System.out.println(consumer);
        System.out.println("**************************");

        Consumer<String> con1 = (String s) ->{
            System.out.println(s);
        };

        con1.accept("听懂了");
    }

    // 语法格式3： 数据类型可以省略，因为可以由编译器腿短的初， 类型推断
    @Test
    public void test3(){
        Consumer<String> consumer = (s) ->{
            System.out.println(s);
        };
        consumer.accept("区别是什么");
        System.out.println(consumer);
    }

    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>(); // 类型推断
        int[] arr = new int[]{1,2,3};
        int[] arr1 = {1,2,3};
    }

    // Lambda只需要一个参数 参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String> consumer = s ->{
            System.out.println(s);
        };
        consumer.accept("区别是什么");
        System.out.println(consumer);
    }
    // Lambda只需要两个参数以上参数 多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 13);
        System.out.println(compare1);

        System.out.println("*********************");

        Comparator<Integer> com2 = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,32));
    }

    // 语法格式六: 当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test7(){

        Comparator<Integer> com1 = (o1,o2) ->{
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12,32));
        System.out.println("*********************");
        Comparator<Integer> com2 = (o1,o2) ->  o1.compareTo(o2);
        System.out.println(com2.compare(12,32));
    }

    @Test
    public void test8(){
        Consumer<String> consumer = s ->System.out.println(s);
        consumer.accept("区别是什么");
        System.out.println(consumer);
    }
}

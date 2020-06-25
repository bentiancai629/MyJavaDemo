package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断言型接口 Predicate<T> boolean test(T t)
 *
 * @author Eric Ni
 * @create 2020-06-25 12:56
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买了一瓶水价格为："+aDouble);
            }
        });

        System.out.println("***************");

        happyTime(500,money-> System.out.println("买了一瓶水价格为："+money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("上海","北京","南京", "东京");
        List<String> filterString =filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);

        System.out.println("*******************");

        List<String> filterStr1 = filterString(list, s->s.contains("京"));
        System.out.println(filterStr1);
    }

    // 根据给定的规则过滤集合中的字符串
    public List<String> filterString(List<String> list, Predicate<String > pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }

}

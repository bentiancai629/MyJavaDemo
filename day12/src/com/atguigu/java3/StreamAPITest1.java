package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Eric Ni
 * @create 2020-06-25 15:02
 */
public class StreamAPITest1 {

    // 1. 筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        // filter(Predicate p) - 接受lambda，从流中排除某些元素。
        stream.filter(e ->e.getMoney() > 6000).forEach(System.out::println);
        System.out.println();

        // limit(n) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        // skip(n) - 跳过元素
        list.stream().skip(1).forEach(System.out::println);
        System.out.println();

        // distinct() - 筛选
        list.add(new Employee(1010,"周星驰",40,350.00));
        list.add(new Employee(1010,"周星驰",40,350.00));
        list.add(new Employee(1010,"周星驰",40,350.00));
        list.add(new Employee(1010,"周星驰",40,350.00));

//        System.out.println(list);
//        System.out.println();
        list.stream().distinct().forEach(System.out::println);
    }


    // 映射
    @Test
    public void test2(){
//        map(Function F) 接收一个函数作为参数 将元素转换成其他形式或提取信息 该函数会
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        // 练习1:
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name->name.length()>3).forEach(System.out::println);

        // 练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s-> {
            s.forEach(System.out::println);
        });

        // flatMap(Functiuon f) - 接口手一个函数作为参数，将流中每一个值换成另一个流，然后把所有流连接成一个流

        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    // 将字符串中的多个字符构成的结合转换为对应的stream
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    // 映射
    @Test
    public void test3(){
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.addAll(list2);
        System.out.println(list1);
    }

    // 排序
    @Test
    public void test4(){
        // sorted()自然排序
//        List<Integer> list = Arrays.asList(12, 43, 55, 23, 0, -92, 8);
//        list.stream().sorted().forEach(System.out::println);

//
        List<Employee> employees = EmployeeData.getEmployees();
//        抛异常 Employee没有实现Comparator接口
//        employees.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)定制排序
        employees.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);

//        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

        employees.stream().sorted((e1,e2)->{
            int returnVal =  Integer.compare(e1.getAge(),e2.getAge());
            if (returnVal!=0){
                return returnVal;
            }else {
                return Double.compare(e1.getMoney(),e2.getMoney());
            }
        }).forEach(System.out::println);


    }
}

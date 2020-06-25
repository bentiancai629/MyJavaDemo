package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import javax.crypto.interfaces.PBEKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Eric Ni
 * @create 2020-06-25 14:15
 */
public class StreamAPITest {

    // 创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

//        defaut Stream<E> stream(); // 返回顺序流
        Stream<Employee> stream = employees.stream();

//        defaut Stream<E> parallelStream(); // 返回并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }


    // 创建Stream方式一：通过数组
    @Test
    public void test2(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jack");
        Employee[] employees = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    // 创建Stream方式一：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    // 创建Stream方式一：创建无限流
    @Test
    public void test4(){
        // 迭代
//        public static<T> iteratar()
        // 遍历前10个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        // 生成
//        public static<T> generate
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}

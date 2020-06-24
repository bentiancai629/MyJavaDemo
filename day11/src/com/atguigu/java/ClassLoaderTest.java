package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Eric Ni
 * @create 2020-06-24 13:10
 */
public class ClassLoaderTest {

    @Test
    public void test1() {

        // 对于自定义类 使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent()：获取拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 调用拓展类加载器的getParent(): 无法获取引导类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        // String也是引导类加载器
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /**
     * Properties: 用来读取配置文件
     *
     */
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
        // 读取配置文件方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties"); // module day11下面
//        pros.load(fis);

        // 读取配置文件方式二：
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties"); //src目录下
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = "+password);
    }
}

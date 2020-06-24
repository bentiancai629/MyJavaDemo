package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Eric Ni
 * @create 2020-06-24 13:35
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /**
         * newInstance(): 创建对应的运行时类的对象，调用运行时类空参构造器
         *
         * 要此方法正常创建运行时类对象 要求：
         * 1. 提供空参构造器
         * 2. 空参构造器访问权限得够。通常设置public
         *
         * 在javabean中要求提供一个public的空参构造器。原因：
         * 1. 便于通过反射，创建运行时类对象
         * 2. 便于子类继承此运行时类 默认调用super()时，保证父类有此构造器
         */
        Person obj = clazz.newInstance(); // 空参构造器
        System.out.println(obj);
    }

    // 反射的动态性
    @Test
    public void test2() {

        for (int i = 0; i < 5; i++) {
            int num = new Random().nextInt(3); //0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /*
       创建一个指定类的对象
       classPath：指定类的全名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();

    }
}

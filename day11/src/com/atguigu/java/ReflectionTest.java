package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Eric Ni
 * @create 2020-06-22 22:46
 */
public class ReflectionTest {

    // 反射之前
    @Test
    public void test1(){

        // 1. 创建Person类
        Person p1 = new Person("Tom",12);

        // 2. 通过对象调用内部属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        // 3. 调用方法
        p1.show();

        // Person类外部 不可以通过Person类对象调用其属性
    }

    // 反射之后
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2. 通过反射调用对象指定的属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,13);

        //3. 通过反射调用对象指定的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //4. 通过反射可以调用类的私有属性构造器和方法
        // 调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        // 调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Han");

        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
       String nation = (String)showNation.invoke(p1,"中国");
        System.out.println(nation);
    }

    // 疑问1：通过new方式或者反射的方式都可以调用公共的结构，咖啡啊中用哪一个？
    // 建议：直接new的方式
    // 什么时候会使用：反射的方式。反射的特征：动态性
    // 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    // 封装性和单例模式是调用的规范性，反射解决了能否调用的问题。

    /**
     *
     * 关于java.lang.class类的理解
     *
     * 1. 类的加载过程
     * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)
     * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于某个字节码文件加载到内存中。此过程我们称为类的加载。加载到内存中的类，我们称为运行时类，
     * 此时运行时类，就作为Class的一个实例
     *
     * 2. Class的实例就是对应着一个运行时类
     * 3. 加载到内存中的运行时类，会缓存一定的时间。在此事件之内，我们可以通过不同的方式
     */

    // 获取Class的实例的方式
    @Test
    public void test3() throws Exception{

        // 方式一：调用运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式二：电泳运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三：调用Class的静态方法：forName（String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);

    }

    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];

        Class c10 = a.getClass();
        Class c11 = b.getClass();

        // 只要元素的类型和维度一样 就是同一个Class
        System.out.println(c10 == c11); // 比较指针
    }
}

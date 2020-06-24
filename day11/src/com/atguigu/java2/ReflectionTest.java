package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Eric Ni
 * @create 2020-06-24 16:22
 */
public class ReflectionTest {
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        // 获取运行时类的对象
        Person p = (Person) clazz.newInstance();

        // 获取指定属性
        Field id = clazz.getField("id");
        Field age = clazz.getField("age"); // 默认权限

        // 设置当前属性的值 //必须public
        id.set(p, 1001);
        int pId = (int) id.get(p);
        System.out.println(pId);
//        age.set(p,12);
//        System.out.println(p.age);
    }

    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;

        // 获取运行时类的对象
        Person p = (Person) clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    /*

     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;

        // 获取运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*
        1. 获取指定的某个方法
        getDeclaredMethod(): 参数1: 指明获取的方法的名称
                             参数2: 指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        /*
        调用方法的invoke(): 参数1：方法的调用者 参数2：指明获取的方法的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object returnValue = show.invoke(p, "CHN"); //String nation = p.show("CHN");
        System.out.println(returnValue);

        System.out.println("**********************如何调用静态方法**************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果调用的运行时类没有返回值(void) 则此invoke()返回null
//        Object returnVal = showDesc.invoke(Person.class);
        Object returnVal = showDesc.invoke(null);
        System.out.println(returnVal);
    }

    /*
    如何调用运行时类的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        /*
        1. 获取指定的构造器
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2. 保证此构造器是可访问的
        constructor.setAccessible(true);

        //3. 调用此构造器创建运行时类的对象
        Person p = (Person)constructor.newInstance("Tom");
        System.out.println(p);
    }
}

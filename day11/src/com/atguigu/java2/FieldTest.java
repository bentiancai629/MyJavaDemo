package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Eric Ni
 * @create 2020-06-24 14:25
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;

        // 获取属性结构
        // getFields()：获取当前运行时类及其父类的public访问权限的属性
        Field[] fields = clazz.getFields();
        System.out.println(fields);
        for (Field f: fields){
            System.out.println(f);
        }
        System.out.println();

        // getDeclaredFields(): 获取当前运行时类什么的所有属性（不包含父类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields){
            System.out.println(f);
        }
        System.out.println();
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields){
            // 1. 权限修饰符
            int modifier = f.getModifiers();
            System.out.println("权限修饰符:"+Modifier.toString(modifier)+"\t");

            // 2. 数据类型
            Class type = f.getType();
            System.out.println("数据类型:"+type.getName()+"\t");

            // 3. 变量名
            String fName = f.getName();
            System.out.println("变量名:"+fName);

            System.out.println();
        }
    }

}

package com.atguigu.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Eric Ni
 * @create 2020-05-31 15:28
 */
@Target({ElementType.METHOD,ElementType.TYPE}) // 可以修饰方法 构造器，属性
@Retention(RetentionPolicy.CLASS) // 什么周期
public @interface MyAnnotation {
//     默认值
    String value() default "hello";
    String[] strArr() default {"a","b","c"};


}

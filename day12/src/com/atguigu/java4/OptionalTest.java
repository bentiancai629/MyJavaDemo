package com.atguigu.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional.of(T t) 创建一个空的Optional实例 t必须非空
 * Optional.empty(T t) 创建一个空的Optional实例
 * Optional.ofNullable(T t) t可以为Null
 *
 * @author Eric Ni
 * @create 2020-06-25 22:40
 */
public class OptionalTest {

    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl); // 报错
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl); // 报错\
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);  // boy不能为null
        System.out.println(girlName);
    }

    // 优化以后
    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);  // boy不能为null
        System.out.println(girlName);
    }

    //  使用Optional类的getGirlName();
    public String getGirlName2(Boy boy){
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);

        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("古力娜扎"));
        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy = new Boy();
        boy = null; // 迪丽热巴
        boy = new Boy(); // 古力娜扎
        boy = new Boy(new Girl("苍老师")); // 苍老师
        String girlName = getGirlName2(boy);  // boy不能为null
        System.out.println(girlName);
    }
}


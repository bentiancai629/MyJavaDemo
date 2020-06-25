package com.atguigu.java;

import org.junit.Test;

public class ExceptionTest1 {

    @Test
    public void test1() {
        String str = "123";
        str = "abc";

        try {
            int num = Integer.parseInt(str);
            System.out.println("hello----1");
        } catch (NumberFormatException e) {
//            System.out.println("数字格式转换异常");
//            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("其他异常");
        } finally {
            System.out.println("finally");
        }

        System.out.println("hello----2");
    }
}

package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

    @Test
    public void test8() throws IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }

        fis.close();
    }

    //    ArithmeticException
    @Test
    public void test7() {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

    //    InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }


    //    NumberFormatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
        System.out.println(num);
    }

    //    .ClassCastException
    @Test
    public void test3() {
        Object obj = new Date();
        String str = (String) obj;
        System.out.println(str);
    }

    //    ArrayIndexOutOfBoundsException:
    @Test
    public void Test2() {
        int[] arr = new int[3];
        System.out.println(arr[4]);
    }

    //    NullPointerException
    @Test
    public void Test1() {
        int[] arr = null;
        System.out.println(arr[3]);
    }
}



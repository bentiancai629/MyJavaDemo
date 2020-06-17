package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Eric Ni
 * @create 2020-06-16 23:56
 */
public class PropertiesTest {


    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println(name+"--"+age);

    }

}

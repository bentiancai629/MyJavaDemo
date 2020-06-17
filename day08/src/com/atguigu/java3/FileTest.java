package com.atguigu.java3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.annotation.Target;

/**
 * @author Eric Ni
 * @create 2020-06-17 21:53
 */
public class FileTest {

    @Test
    public void test1(){
        // 构造器1
        File file1 = new File("hello1.txt");
        File file2 = new File("D:\\io\\java.txt");

        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParent());
        System.out.println(file1.getAbsolutePath());

        System.out.println();

        // 构造器2
        File file3 = new File("D:\\workspace_idea1", "javaSenior");
        System.out.println(file3);

//        构造器3
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

        //renameTo(File newName):重命名
        //file1.renameTo(file2):file1重命名为file2.要求：file1文件一定存在，file2一定不存在
        boolean b = file1.renameTo(file2);
        System.out.println(b);

        boolean b1 = file1.renameTo(file2);
        System.out.println(b1);
    }
}

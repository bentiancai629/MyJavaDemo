package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1.流的分类：
 * 按照数据流向的不同：输入流  输出流
 * 按照处理数据的单位的不同：字节流  字符流（处理的文本文件）
 * 按照角色的不同：节点流（直接作用于文件的）  处理流
 * <p>
 * 2.IO的体系
 * 抽象基类			节点流（文件流）                                缓冲流（处理流的一种）
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 *
 * @author Eric Ni
 * @create 2020-06-17 22:19
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("C:\\JavaProjects\\MyJavaDemo\\hello.txt");
        System.out.println(file.getAbsolutePath());

        File file1 = new File("C:\\JavaProjects\\MyJavaDemo\\day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());

    }

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // 1. 实例化File类的对象
            File file = new File("D:\\io\\hello.txt");
            // 2. 提供具体的流
            fr = new FileReader(file);
            // 3. 数据的读入
//        int read = fr.read();
//        while (read != -1){
//            System.out.println((char)read);
//            read = fr.read();
//        }

            // 方法二：
            int read;
            while ((read = fr.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流的关闭操作
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // read()升级操作 使用read重载
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
//        1. file类的实例化
            File file = new File("hello.txt");
//        2. FileReader流的实例化
            fr = new FileReader(file);

//        3. 读入的操作
            // read(char[] cbuf)返回每次读入cbuf中的字符个数，达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                // 错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.println(cbuf[i]);
//                }
                // 正确的写法
//                for (int i=0;i<len;i++){
//                    System.out.println(cbuf[i]);
//                }

//                方式二:
                // 错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);

                // 正确的写法
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
            // 4. 流的关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriter() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fw = new FileWriter(file,true);
        fw.write("I have a dream. ");
        fw.write("I have a dream,too");
        fw.close();
    }

}

package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 1. 直接接触java.lang.Object类，实现DataInput和DataOutput接口
 * 2. 既可以作为输入流，也可以作为输出流
 * 3. 如果作为输出流，写到的文件不存在，则实行过程中自动创建，
 *    如果写出到的文件存在，会对原有文件内容进行覆盖
 *
 * @author Eric Ni
 * @create 2020-06-21 10:26
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {

            raf1 = new RandomAccessFile(new File("pic.jpg"), "r");
            raf2 = new RandomAccessFile(new File("pic1.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;

            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 对内容覆盖
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = null;

        raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
        raf1.write("xyz".getBytes());
        raf1.close();

    }

    // 对内容覆盖
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = null;
        raf1 = new RandomAccessFile(new File("hello.txt"), "rw");

        raf1.seek(3);
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[1024];
        int len;

        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        // 调回指针
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.close();

    }
}

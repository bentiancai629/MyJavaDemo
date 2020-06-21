package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 内存中的java对象博爱存到磁盘或者通过网络传输出去
 *
 * @author Eric Ni
 * @create 2020-06-21 9:12
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
//            oos.writeObject(new String("我爱中国"));
//            oos.flush(); // 刷新

            // person对象序列化
            oos.writeObject(new Person("Tom",123));
            oos.flush(); // 刷新

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将磁盘中的文件还原为内存中的java对象
     * 使用OutputStream实现
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
//            String str = (String) obj;
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

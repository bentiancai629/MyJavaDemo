package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Eric Ni
 * @create 2020-06-20 11:19
 */
public class BufferedTest {

    @Test
    public void testBufferedInputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 造文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            // 造字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 复制
            byte[] buffer = new byte[10];
            int len = 0;
            while ((bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
            // 关闭资源
            // 先关闭外层
            {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null)
            // 关闭资源
            // 先关闭外层
            {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null)
            // 关闭资源
            // 先关闭外层
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null)
            // 关闭资源
            // 先关闭外层
            {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

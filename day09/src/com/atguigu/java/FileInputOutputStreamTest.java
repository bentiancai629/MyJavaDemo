package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * 测试FileInputStream和FileOutputStream
 * <p>
 * 结论：对于文本文件，使用字符流处理
 * 对于非文本文件，使用字节流处理
 *
 * @author Eric Ni
 * @create 2020-06-20 0:12
 */
public class FileInputOutputStreamTest {

    /**
     * 使用字节流FileInputStream处理文本
     * ASCII 英文字母1个byte
     * 中文3个byte
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file);

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void CopyFile() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("pic.jpg");
            File destfile = new File("pic2.jpg");

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void copyFile(String srcPath,String destPath ){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buffer = new byte[1024000];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    // 复制文件指定路径
    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\huoying.rmvb";
        String destPath = "C:\\Users\\Administrator\\Desktop\\huoying2.rmvb";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制花费时间："+(end-start));
    }
}


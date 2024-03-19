package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Common-zhou
 * @since 2024-03-19 16:36
 */
public class Demo2Create {

    @Test
    public void test1() throws IOException {
        // 只负责创建文件，目录路径如果不存在，会报错而不是帮你创建
        // public boolean createNewFile()

        // 这些方法，都是什么方法？ 这个是个成员方法，只有你创建了对象之后，才能调用这个方法。
        File file = new File("2.txt");

        // Unhandled exception: java.io.IOException

        file.createNewFile();

        System.out.println("====================");
        File file2 = new File("test2/test3/2.txt");

        file2.createNewFile();
    }

    @Test
    public void test2Mkdir() {
        //只负责创建目录，但只能创建单层目录，如果有多级目录不存在的话，创建失败。不会报错
        // public boolean mkdir()

        File file1 = new File("test1/test2/test3");

        // 布尔值： true代表创建成功； false代表创建失败。
        // boolean result = file1.mkdir();
        // System.out.println(result);

        //只负责创建目录，但可以创建多级目录，如果多级目录不存在，则帮你全部创建
        // public boolean mkdirs()

        file1.mkdirs();
    }


}

package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * @author Common-zhou
 * @since 2024-03-19 17:11
 */
public class Demo6 {
    @Test
    public void test1() {
        // //获取File对象表示的抽象文件的绝对路径
        // public String getAbsolutePath()
        //
        // //获取File对象表示的抽象文件，路径名字符串
        //         public String getPath()
        //
        // //获取文件或者目录的名字
        //         public String getName()
        //
        // //返回由此抽象路径名表示的文件的长度。不能返回文件夹的长度
        // //此抽象路径名表示的文件的长度，以字节为单位；如果文件不存在，则返回 0L
        //         public long length()
        //
        // //返回此抽象路径名表示的文件最后一次被修改的时间。
        // //表示文件最后一次被修改的时间的 long 值，用与时间点（1970 年1月1日，00:00:00 GMT）之间的毫秒数表示
        //         public long lastModified()
    }


    @Test
    public void test2() {
        File file = new File("1.txt");

        String path = file.getAbsolutePath();
        System.out.println(path);

        String path1 = file.getPath();
        System.out.println(path1);

        System.out.println("file.getName() = " + file.getName());

        System.out.println("file.length() = " + file.length());

        // 时间戳。
        System.out.println("file.lastModified() = " + file.lastModified());

        System.out.println("new Date(file.lastModified()) = " + new Date(file.lastModified()));
    }
}

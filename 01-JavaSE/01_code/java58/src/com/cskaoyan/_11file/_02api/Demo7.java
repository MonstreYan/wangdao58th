package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;

/**
 * @author Common-zhou
 * @since 2024-03-19 17:15
 */
public class Demo7 {
    @Test
    public void test1() {
        //返回一个字符串数组，这些字符串包括，此抽象的路径名表示的目录中的所有文件和文件夹的名字
        //如果File对象表示的是一个文件，则返回null
        //只能获取当前目录的下一层，并不是获取所有层级
        //如果是一个空目录，返回一个长度为0的数组，而不是null  []
        // public String[] list()

        File file = new File("1.txt");
        // 如果File对象表示的是一个文件，则返回null
        String[] list = file.list();

        if (list == null) {
            // 判断null。这样写。
        }
        // for (String s : list) {
        //     System.out.println(s);
        // }


        System.out.println("========================");

        // File file1 = new File("src/com/cskaoyan");
        File file1 = new File("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE");
        String[] list1 = file1.list();

        if (list1 != null) {
            for (String s : list1) {
                System.out.println(s);
            }
        }

        // 返回文件夹，也会返回文件

    }


    @Test
    public void test2() {
        //返回指定File目录下的文件和文件夹的绝对路径形式的File对象数组
        //如果File对象表示的是一个文件，则返回null
        //只能获取当前目录的下一层，并不是获取所有层级
        //如果是一个空目录，返回一个长度为0的数组，而不是null
        // public File[] listFiles()

        File file = new File("src/com/cskaoyan");
        File[] files = file.listFiles();

        if (files != null) {
            for (File file1 : files) {
                System.out.println("file1.getName() = " + file1.getName());
            }
        }

    }
}

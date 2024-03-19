package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;

/**
 * 判断某个目录(单级)下有没有a.jpg文件,有的话输出
 *
 * @author Common-zhou
 * @since 2024-03-19 17:24
 */
public class Demo8 {
    @Test
    public void test1() {
        // C:\Users\zhoubing\Desktop\java-58-course-materials\01-JavaSE
        File file = new File("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE");

        String[] list = file.list();
        if (list != null) {
            for (String fileName : list) {
                // if (fileName.equals("a.jpg")) {
                if ("a.png".equals(fileName)) {
                    System.out.println(fileName);
                }
            }
        }
    }

    @Test
    public void test2() {
        // 递归输出某个目录下的所有java文件
        //

        File file = new File("./");

        searchDirectorySuffixJava(file);
    }

    private void searchDirectorySuffixJava(File file) {

        // 现在，拿到一个 File. 我现在，怎么递归做。

        if (file == null) {
            return;
        }

        if (file.isFile()) {
            String name = file.getName();
            // 是个文件。
            if (name != null && name.endsWith(".java")) {
                // 说明是Java文件
                System.out.println(file.getAbsolutePath());
            }
            return;
        }

        File[] files = file.listFiles();

        for (File childFile : files) {
            if (childFile.isFile()) {
                // 如果是个  文件。直接判断后缀。
                String name = childFile.getName();
                if (name != null && name.endsWith(".java")) {
                    // 说明是Java文件
                    System.out.println(childFile.getAbsolutePath());
                }
            } else if (childFile.isDirectory()) {
                searchDirectorySuffixJava(childFile);
            }
        }
    }

    @Test
    public void test4() {
        // 递归最重要的就是： 递归的出口。
        // 方法调用本身
    }

    @Test
    public void test5() {
        // 递归删除某个文件夹。
        // 晚上删的时候，一定不要去删C盘。 随便找一个无关紧要的文件夹实验。
    }

}

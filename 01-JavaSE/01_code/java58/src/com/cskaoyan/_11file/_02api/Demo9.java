package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Common-zhou
 * @since 2024-03-19 17:43
 */
public class Demo9 {
    @Test
    public void test1() {
        // 高级筛选功能
        File file = new File("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE");


        // 匿名内部类。
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                // true代表留下。 false代表不留

                if (pathname.isDirectory()) {
                    return false;
                }

                String name = pathname.getName();

                return name.endsWith(".java");
            }
        });

        File[] files2 = file.listFiles(pathname -> {

            // true代表留下。 false代表不留

            if (pathname.isDirectory()) {
                return false;
            }

            String name = pathname.getName();

            return name.endsWith(".java");
        });


        for (File file1 : files) {
            System.out.println("file1 = " + file1);
        }


    }
}

package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;

/**
 * @author Common-zhou
 * @since 2024-03-19 17:01
 */
public class Demo3RenameTo {
    @Test
    public void test1() {
        // 重新命名此抽象路径名表示的文件
        // public boolean renameTo(File dest)

        // - 在源文件，和修改之后的目标文件在同一目录的时候：
        //   - 效果只是重命名
        // - 当源文件和，修改之后的目标文件当不在同一目录的时候：
        //   - 移动文件
        //   - 重命名


        File oldFile = new File("1.txt");
        File newFile = new File("111.txt");

        // 目录没有变化。 这个时候，只有改名的效果
        oldFile.renameTo(newFile);
    }

    @Test
    public void test2() {
        File oldFile = new File("111.txt");

        File newFile = new File("test1/222.txt");
        oldFile.renameTo(newFile);

        //
    }
}

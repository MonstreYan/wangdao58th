package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;

/**
 * @author Common-zhou
 * @since 2024-03-19 17:07
 */
public class Demo4Delete {
    @Test
    public void test1() {
        // 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除
        // delete不会因为文件不存在,路径名不正确而抛出异常,只会返回false, 并且不会进入回收站
        // public boolean delete()

        // 删除文件的时候，如果能删就删； 删不了也不会报错。
        File file = new File("2.txt");
        file.delete();
    }

    @Test
    public void test2() {
        File file = new File("test1/test2");
        file.delete();

        // 删除目录的时候，目录一定要为空才能删。

    }
}

package com.cskaoyan._19collection._03list._01introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-03-30 11:11
 */
public class Demo2 {
    @Test
    public void test1() {
        // List是Collection的子接口。所有肯定有Collection的所有方法。
        // Collection的API我们已经学习过，所以直接学习List所特有的。
        List<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");

        // list.addAll()
        // list.remove()
        // list.contains()
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();

            System.out.println(next);
        }
    }


    @Test
    public void test3() {
        // List
    }
}

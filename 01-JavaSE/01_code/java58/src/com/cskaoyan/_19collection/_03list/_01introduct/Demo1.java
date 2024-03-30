package com.cskaoyan._19collection._03list._01introduct;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-03-30 11:07
 */
public class Demo1 {

    @Test
    public void test1() {
        // 1. 存储数据有序。（存储进去的顺序和读取出来的顺序。 完全一致或者完全相反）
        // List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("wu1");
        list.add("wu2");
        System.out.println(list);
    }

    @Test
    public void test2() {
        // 2. 可以存储重复元素
        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(10);
        System.out.println(list);


        // 3. 可以存储null

        list.add(null);

        System.out.println(list);
    }
}

package com.cskaoyan._19collection._03list._02api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 关于写法的问题。
 *
 * @author Common-zhou
 * @since 2024-04-01 15:51
 */
public class Demo5Notice {
    @Test
    public void test1() {
        // 现在，学了很多东西。  Collection、 List(线性表。)、ArrayList
        // 今后写代码怎么写？

        // Collection  --

        Collection<String> collection = new ArrayList<>(); // 使用Collection来接，可能有一些API点不出来。
        List<String> list = new ArrayList<>(); // List接口，已经能点出来大部分的方法了。
        ArrayList<String> strings = new ArrayList<>();

        // 这三种写法， 怎么写比较好？

        // 建议大家使用第二种。
        // List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        // ArrayList<String> strings = new LinkedList<>();
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        // 这种写法，更好一点。
    }
}

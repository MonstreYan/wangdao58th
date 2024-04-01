package com.cskaoyan._19collection._03list._02api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-04-01 15:09
 */
public class Demo4SubList {

    @Test
    public void test1() {
        //    List<E> subList(int fromIndex, int toIndex)
        // 截断List. 非常容易混淆。 不是截断。是操作的原有集合的一部分。

        List<String> list = new ArrayList<>();

        list.add("茶百道");
        list.add("茶颜悦色");
        list.add("蜜雪冰城");
        list.add("七分甜");
        list.add("霸王茶姬");

        // [fromIndex, toIndex): 返回的是视图。 你操作，影响的是原本的集合。
        List<String> list1 = list.subList(1, 3);

        System.out.println(list1);

    }

    @Test
    public void test2() {
        //    List<E> subList(int fromIndex, int toIndex)
        // 截断List. 非常容易混淆。 不是截断。是操作的原有集合的一部分。

        List<String> list = new ArrayList<>();

        list.add("茶百道");
        list.add("茶颜悦色");
        list.add("蜜雪冰城");
        list.add("七分甜");
        list.add("霸王茶姬");

        // 是视图，视图是指。你操作这个list1，会影响原本的结合。
        // 茶颜悦色  蜜雪冰城  6666
        List<String> list1 = list.subList(1, 3);
        list1.add("66666");

        System.out.println(list);

        System.out.println(list1);
        // 是一个视图。 也就是，你操作生成的这个，会影响原本的集合。
        // 或者说，这个玩意，根本不是生成了一个新的， 只是在原本的集合上操作。
    }


    @Test
    public void test3() {
        final List<String> list = new ArrayList<>();

        list.add("茶百道");
        list.add("茶颜悦色");
        list.add("蜜雪冰城");
        list.add("七分甜");
        list.add("霸王茶姬");
        list.add("霸王茶姬");

        System.out.println(list);

        List<String> list1 = list.subList(1, 4);

        // subList 只是一个视图。 它并不自己存储数据，它操作的数据，都是原本的集合。
    }

    @Test
    public void test4() {

        List<List<String>> resultList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            // 创建了长度是 100w大小的数组
            // List<String> list = new ArrayList<>(1_000_000);
            List<String> list = new ArrayList<>();
            list.add("zs");

            List<String> subList = list.subList(0, 1);
            resultList.add(subList);
        }

        // 现在，肯定是有1w个数据的。 问题
        // 现在的1w个数据。里面的每一条数据，到底大小是1,还是100w。
        // [subList, subList, subList, .......]
        // 存储的是100w。
        // subList的大小，并不是由它的size决定。而是取决于，是谁生成的subList。
    }
}

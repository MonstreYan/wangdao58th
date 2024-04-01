package com.cskaoyan._19collection._03list._02api;

import org.junit.Test;

import java.util.*;

/**
 * @author Common-zhou
 * @since 2024-04-01 09:31
 */
public class Demo2Review {
    @Test
    public void test1() {
        // List接口存储数据有序。允许存储重复元素，允许存储null。
        // 存储数据的顺序和读取的顺序，是否完全一致，或者完全相反。
        // 让大家对容器中的数据，有一个了解。
        // 1 6 9 2 3
        // 1 6 9 2 3    3 2 9 6 1

        // List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();

        list.add("zs");
        list.add("wu");
        list.add("ls");
        list.add("wu");
        list.add("zl");
        list.add("wu");
        list.add(null);

        System.out.println(list);
    }


    @Test
    public void test2() {
        // List接口，是Collection接口的子接口。 所以Collection里面有的，List里面也有。
        // List里面新增了一些API。 关于下标的API。

        List<String> list = new LinkedList<>();

        // API怎么捋？ 增删改查、 特殊API、 遍历API
        // list.add();
        // list.remove()
        // list.contains()

        // list.clear();
        // list.size()
        // list.isEmpty()

        // list.toArray()
        // list.iterator()

    }


    @Test
    public void test3() {
        // List接口里面，新增了一批API。 就是很多关于对下标的操作。
        // 增删改查.
        // Collection<String> list = new ArrayList<>();
        // List<String> list = new ArrayList<>();
        // ArrayList<String> list = new ArrayList<>();
        List<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");

        //     zs     ls      wu     zl
        //     0      1        2      3    4

        // System.out.println(list);
        // [0, length]
        // list.add(0, "666");
        // System.out.println(list);

        System.out.println(list);
        list.remove(1);
        System.out.println(list);

        // list.set()  和数组里面什么方法.  array[index] = 666;
        // list.get()
        // list.indexOf()
    }


    @Test
    public void test4() {
        // ArrayList的底层是一个数组。 数组的初始化值是多少。

        // 1.肯定要看构造方法。构造方法里面也许会对数组进行初始化。
        ArrayList<String> strings = new ArrayList<>();

        strings.add("zs");
        strings.add("zs");
        strings.add("zs");
        strings.add("zs");
        strings.add("zs");
        strings.add("zs");
        strings.add("zs");

        strings.add("zs");

        // 比如，现在数组的长度是10. 不断往里面添加数据。 在添加的过程中，会扩容。
        // 所以，扩容，也是看添加方法。
    }


    @Test
    public void test5() {
        // ArrayList里面一些方法。 是怎么实现的
        ArrayList<String> strings = new ArrayList<>();

        strings.add("zs");

        strings.size();
        strings.indexOf("zs");

        strings.remove(0);

        strings.remove("111");


        // 迭代器的API。
        Iterator<String> iterator = strings.iterator();

        // LinkedList里面

        LinkedList<String> list = new LinkedList<>();
        Iterator<String> iterator1 = list.iterator();

    }




}

package com.cskaoyan._19collection._02collection._03feature;

import org.junit.Test;

import java.util.*;

/**
 * @author Common-zhou
 * @since 2024-03-29 10:34
 */
public class Demo1 {
    @Test
    public void test1() {
        // 1. Collection是顶级接口，用描述数据存储的接口.
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.remove("zs");
        System.out.println(collection);
    }

    @Test
    public void test2() {
        // 2. Collection的一些子实现有序，一些无序
        // 等到学完之后，自己梳理梳理。 哪些有序，哪些无序。

        // 6 7 5 2 1
        // 1 2 5 6 7

        // 什么叫有序，什么叫无序。
        // 一般情况会认为， 大小有序。
        // 这里说的有序和无序，是指存储和读取的数据，是否完全一致或相反 。
        // 比如，进去的时候是这个。 6 7 5 2 1  出来的时候也是这个，我们就称它有序。
        // 今后写代码的时候，你了解数据存进去和读出来的顺序，能让你更了解数据。

        // Collection<String> collection = new ArrayList<>();
        // Collection<String> collection = new LinkedList<>();
        // Collection<String> collection = new HashSet<>();
        Collection<String> collection = new TreeSet<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zl");

        System.out.println(collection);


    }


    @Test
    public void test3() {
        // 3. 一些子实现允许存储重复的数据，一些不允许
        // Collection<String> collection = new ArrayList<>();
        // Collection<String> collection = new LinkedList<>();
        Collection<String> collection = new HashSet<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("zs");
        collection.add("wu");

        System.out.println(collection);


    }

    @Test
    public void test4() {
        // 4. 一些子实现允许存储null，一些不允许
        // Collection<Integer> collection = new HashSet<>();
        // Collection<Integer> collection = new ArrayList<>();
        Collection<Integer> collection = new TreeSet<>();

        collection.add(10);
        collection.add(6);
        collection.add(8);
        collection.add(null);

        System.out.println(collection);

    }

    @Test
    public void test5(){
        // 传统的三件套。
        // 1.数据存储是否有序。
        // 2.是否允许存储重复元素
        // 3.是否允许存储null

        // 可以帮助我们更了解这个容器。
    }
}

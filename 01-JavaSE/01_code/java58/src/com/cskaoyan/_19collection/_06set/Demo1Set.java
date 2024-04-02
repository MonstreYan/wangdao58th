package com.cskaoyan._19collection._06set;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Common-zhou
 * @since 2024-04-02 14:31
 */
public class Demo1Set {
    @Test
    public void test1() {
        //Set就一个大特点， 不允许存储重复元素。
        // Set的底层，全是Map.

        // HashSet的底层，是HashMap
        HashSet<String> strings = new HashSet<>();
        strings.add("zs");
        strings.add("ls");

        strings.remove("zs");

        // TreeSet。 TreeMap.
        TreeSet<String> strings1 = new TreeSet<>();
        strings1.add("zs");

        // Set的底层，都是使用的Map。 所以Set先不学，等到Map学完就会了。
    }

    @Test
    public void test2() {
        // Set怎么遍历？
        // 迭代器、toArray
    }
}

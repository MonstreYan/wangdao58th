package com.cskaoyan._19collection._02collection._04api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Common-zhou
 * @since 2024-03-29 11:33
 */
public class Demo2 {
    @Test
    public void test1() {
        //    ---------------------------------特殊方法---------------------------------
        //    void clear()： 清空collection
        //    boolean isEmpty(): 是否为空
        //    int size()： collection里面的元素个数
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");

        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.isEmpty() = " + collection.isEmpty());

        collection.clear();
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
    }

    @Test
    public void test2() {
        //    boolean equals(Object o) ： 判断是否相等
        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("zs");
        // collection1.add("ls");

        System.out.println("collection.equals(collection1) = " + collection.equals(collection1));
    }


    @Test
    public void test3() {
        //    int hashCode()： 计算hashCode
        // Object里面的方法，如果不重写，里面默认怎么实现。 地址。

        // 集合类中的hashCode被重写了。重写的策略就是和每个元素都相关。
        // 1 2 1
        // 2 1 1
        // 如果只是单纯的加。
        // 实现的时候，不是单纯的加。 还有个权。 31
        // hashCode没重写的时候，就和地址相关； 重写的策略： 和元素的里面的内容相关。 和equals依据相关。

        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(1);
        collection1.add(1);
        collection1.add(2);

        System.out.println("collection.hashCode() = " + collection1.hashCode());
        Collection<Integer> collection2 = new ArrayList<>();
        collection2.add(1);
        collection2.add(2);
        collection2.add(1);

        System.out.println("collection2.hashCode() = " + collection2.hashCode());
    }
}

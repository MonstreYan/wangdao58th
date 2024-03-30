package com.cskaoyan._19collection._03list._02api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-03-30 11:14
 */
public class Demo1 {
    @Test
    public void test1() {
        //  List是线性表的实现，所以它相对于Collection增加了很多下标相关的API
        //    void add(int index, E element)： 在指定位置添加元素。list添加的位置，只能在[0,length之间]

        // 1.要用这个方法。 只能用什么接口 ==>List接口。

        Collection<String> collection = new ArrayList<>();
        // collection.add()

        List<String> collection1 = new ArrayList<>();
        collection1.add("zs");
        collection1.add("ls");
        collection1.add("wu");

        //    zs    ls    wu
        //     0
        System.out.println("collection1 = " + collection1);
        collection1.add(0, "666");
        System.out.println("collection1 = " + collection1);

        // collection1.add(0, "666");
        // 先挪数据。 然后插入指定位置
    }

    @Test
    public void test2() {
        //    void add(int index, E element)： 在指定位置添加元素。list添加的位置，
        //
        //    只能在[0,length之间]

        //    zs     ls        wu
        //    0       1         2       3    4
        List<String> collection1 = new ArrayList<>();
        collection1.add("zs");
        collection1.add("ls");
        collection1.add("wu");

        // System.out.println("collection1 = " + collection1);
        // collection1.add(3, "7777");
        // System.out.println("collection1 = " + collection1);

        collection1.add(4, "7777");
    }

    @Test
    public void testAddAll() {
        //    boolean addAll(int index, Collection<? extends E> c)： 在指定位置添加一个Collection的所有元素

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        Collection<String> collection = new ArrayList<>();
        collection.add("666");
        collection.add("777");
        collection.add("888");

        System.out.println("list = " + list);
        // list.addAll(3, collection);
        list.addAll(0, collection);
        System.out.println("list = " + list);
    }

    @Test
    public void testRemove() {
        //    E remove(int index)：删除指定下标的元素，只能删除下标的位置[0, length-1]。返回的是删除的元素

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        System.out.println("list = " + list);
        list.remove(0);
        System.out.println("list = " + list);

        //    zs    ls      wu
        //     0     1      2
    }

    @Test
    public void testRemove2() {
        // remove这个方法的坑。

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(110);
        list.add(99);

        Integer index = 0;
        // 如果里面存储的是Integer。 一定要注意这个删除方法
        // 到底选择是 remove(Object o) 还是remove(index)

        System.out.println("list = " + list);
        // list.remove(index);
        list.remove(index.intValue());
        System.out.println("list = " + list);

    }

    @Test
    public void testSet() {
        //    E set(int index, E element)： 设置指定下标的元素为element.   array[index] = element;
        //    E get(int index)： 获取指定下标元素   array[index]

        List<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");

        System.out.println(list);
        list.set(0, "景天");

        System.out.println(list);

        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
    }


    @Test
    public void testGet() {
        // List接口，有get方法。 这里就多了一个遍历方式。

        List<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");
        list.add("wu");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(i) = " + list.get(i));
        }


    }


    @Test
    public void testIndexOf() {
        //    int indexOf(Object o)： 获取元素首次出现的下标。如果元素不存在。 返回的是-1
        //    int lastIndexOf(Object o)： 获取元素最后一次出现的下标。

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");
        list.add("zs");


        System.out.println("list.indexOf(\"zs\") = " + list.indexOf("zs"));
        System.out.println("list.indexOf(\"jingtian\") = " + list.indexOf("jingtian"));
    }

    @Test
    public void test3() {
        // 初始化长度，应该在构造方法里面，进行一下。
        ArrayList<String> strings = new ArrayList<>();

        strings.add("zs");

        strings.get(0);
        strings.remove(0);

        strings.add(0, "zs");


    }


}

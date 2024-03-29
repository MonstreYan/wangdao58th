package com.cskaoyan._19collection._04api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 处理数据，就是在增删改查。 所以增删改查非常重要。
 *
 * @author Common-zhou
 * @since 2024-03-29 11:06
 */
public class Demo1 {
    @Test
    public void testAdd() {
        //    ---------------------------------增删改查方法---------------------------------
        // 需要熟练使用，清楚特点。
        //    boolean add(E e): 添加一个元素进入Collection

        // 看参数，看名字。
        Collection<Integer> collection = new ArrayList<>();
        collection.add(10);
        collection.add(6);
        collection.add(8);
        collection.add(11);

        System.out.println(collection);

        // 回忆一下： 之前往数组塞数据，
        // 之前有一堆学生，现在让你找湖北的学生。
        // Student[] students = new Student[10];

        // Student[] students = new Student[10];

        // 遍历湖北的学生。 collection.add(student);
    }

    @Test
    public void testAddAll() {
        //    boolean addAll(Collection<? extends E> c): 添加一个Collection进目标Collection
        // 有俩Collection。 是哪个往哪个里面添加。
        // 谁调用的这个方法，就是往哪个里面添加

        Collection<Integer> collection = new ArrayList<>();
        collection.add(10);
        collection.add(9);
        collection.add(8);
        collection.add(5);

        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(99);
        collection1.add(97);

        // 是谁调用的这个方法，就改动的是谁。
        // collection1往collection添加
        collection.addAll(collection1);

        System.out.println("collection = " + collection);
        System.out.println("collection1 = " + collection1);
    }


    @Test
    public void testRemove() {
        //    boolean remove(Object o)： 删除元素， 只删除第一个出现的(如果存在多个)
        Collection<String> collection = new ArrayList<>();

        collection.add("茶颜悦色");
        collection.add("喜茶");
        collection.add("奈雪的茶");
        collection.add("喜茶");
        collection.add("茶百道");
        collection.add("喜茶");

        System.out.println(collection);
        collection.remove("奈雪的茶");
        System.out.println(collection);

        collection.remove("喜茶");
        System.out.println(collection);

    }

    @Test
    public void testRemoveAll() {
        //    boolean removeAll(Collection<?> c)： 删除Collection中的所有存在的元素,会全部删除，如果存在多个
        // c1.removeAll(c2) :  c1删除c2里面的所有元素。


        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("ls");
        collection.add("zl");
        collection.add("wu");
        collection.add("ls");

        Collection<String> collection1 = new ArrayList<>();

        collection1.add("zs");
        collection1.add("ls");
        collection1.add("666");

        // collection里面，删掉collection1里面出现的数据
        collection.removeAll(collection1);
        System.out.println("collection = " + collection);
        System.out.println("collection1 = " + collection1);


        // removeAll: 高中集合。
        // 1 2 3   交集  2 3 8 :
        // 差集。

    }

    @Test
    public void testContainsAll() {
        //    boolean contains(Object o)： 判断是否存在指定元素

        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("景天");

        // 是否包含。
        boolean contains = collection.contains("zs");
        System.out.println("contains = " + contains);

        System.out.println("collection.contains(\"景天\") = " + collection.contains("景天"));
    }

    @Test
    public void testContainsAll2() {
        //    boolean containsAll(Collection<?> c)： 判断给定的collection中是否全部存在于目标Collection

        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("zs");
        collection1.add("ls");
        collection1.add("zl");

        boolean b = collection.containsAll(collection1);

        System.out.println("b = " + b);
    }

    @Test
    public void testRetainAll() {
        //    boolean retainAll(Collection<?> c)： 将原有collection只保留传入的collection。
        // c1.retainAll(c2)    : 交集

        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(2);
        collection1.add(3);
        collection1.add(4);

        collection.retainAll(collection1);
        System.out.println("collection = " + collection);

        // 1 2 3
        // 2 3 6
        // 交集：  2 3
        // 并集：  1 2 3 6
        // 差集   1
    }
}

package com.cskaoyan._20map._06other;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Common-zhou
 * @since 2024-04-05 16:05
 */
public class Demo2TreeMap {

    @Test
    public void test1() {
        // 1. TreeMap存储数据大小有序。
        // 2. TreeMap不允许存储重复的key (什么叫重复: key的大小一样)
        // 3. TreeMap不允许存储null作为key:   null没有办法比较大小

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "yi");
        treeMap.put(10, "shi");
        treeMap.put(6, "liu");
        treeMap.put(8, "ba");
        treeMap.put(9, "jiu");
        treeMap.put(7, "qi");

        // treeMap.put(null, "111");

        // {1=yi, 6=liu, 7=qi, 8=ba, 9=jiu, 10=shi}
        System.out.println(treeMap);
    }


    @Test
    public void testConstructor2() {
        // TreeMap()
        // 使用键的自然顺序构造一个新的、空的树映射。
        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("ccc", "123");
        treeMap.put("aaa", "123");
        treeMap.put("bbb", "123");

        System.out.println(treeMap);
        // 如果使用使用自定义的类，作为键。 一定实现Comparable接口。
        // 或者，你告诉它怎么比。 Comparator。

        System.out.println("=====================================");
        TreeMap<User2, String> treeMap1 = new TreeMap<>();
        treeMap1.put(new User2("ls", 19), "lisi");
        treeMap1.put(new User2("wu", 20), "wangwu");
        treeMap1.put(new User2("zs", 18), "zhangsan");

        System.out.println(treeMap1);
    }

    @Test
    public void test3() {
        // TreeMap(Comparator<? super K> comparator)
        // 构造一个新的、空的树映射，该映射根据给定比较器进行排序。
        TreeMap<User21, String> treeMap = new TreeMap<>(new Comparator<User21>() {
            @Override
            public int compare(User21 o1, User21 o2) {
                return o1.age - o2.age;
            }
        });

        treeMap.put(new User21("zs", 18), "zhangsan");
        treeMap.put(new User21("wu", 21), "wangwu");
        treeMap.put(new User21("ls", 19), "lisi");

        System.out.println(treeMap);
    }

    @Test
    public void test4() {
        // 什么叫相等， 什么叫重复。
        // HashMap是怎么认为相等的？
        // hashCode相同； 且equals方法相同。
        // TreeMap怎么认为相等的？
        // 比较器返回的是0，认为相等。
        TreeMap<User21, String> treeMap = new TreeMap<>(new Comparator<User21>() {
            @Override
            public int compare(User21 o1, User21 o2) {
                return o1.age - o2.age;
            }
        });

        treeMap.put(new User21("zs", 18), "zhangsan");
        treeMap.put(new User21("wu", 21), "wangwu");
        treeMap.put(new User21("ls", 19), "lisi");
        treeMap.put(new User21("ls", 19), "123456");

        System.out.println(treeMap);
    }


    // TreeMap(Map<? extends K,? extends V> m)
    // 构造一个与给定映射具有相同映射关系的新的树映射，该映射根据其键的自然顺序 进行排序。
    // TreeMap(SortedMap<K,? extends V> m)
    // 构造一个与指定有序映射具有相同映射关系和相同排序顺序的新的树映射。

}

class User2 implements Comparable<User2> {
    String name;
    int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(User2 o) {
        return this.age - o.age;
    }
}


class User21 {
    String name;
    int age;

    public User21(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User21{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

package com.cskaoyan._20map._05other;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author Common-zhou
 * @since 2024-04-05 15:47
 */
public class Demo1LinkedHashMap {
    @Test
    public void test1() {
        // LinkedHashMap 是 HashMap的子类。 基本全部复用了HashMap的方法和结构。
        // 额外维护了一个双向链表，以保证迭代的顺序。
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("zs", "hubei");
        linkedHashMap.put("ls", "hunan");
        linkedHashMap.put("wu", "henan");
        linkedHashMap.put("zl", "beijing");

        System.out.println(linkedHashMap);
    }


    @Test
    public void test2() {


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, String> linkedHashMap1 = new LinkedHashMap<>(17);
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>(17, 0.75f);


        linkedHashMap.put("zs", "hubei");
        linkedHashMap.put("ls", "hunan");
        linkedHashMap.put("wu", "henan");
        linkedHashMap.put("zl", "beijing");

        System.out.println(linkedHashMap);

        linkedHashMap.size();

        // 只额外加了一个双向链表。
    }


    @Test
    public void test3() {
        // LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
        // 构造一个带指定初始容量、加载因子和排序模式的空 LinkedHashMap 实例。

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);


        linkedHashMap.put("zs", "hubei");
        linkedHashMap.put("ls", "hunan");
        linkedHashMap.put("wu", "henan");
        linkedHashMap.put("zl", "beijing");

        System.out.println(linkedHashMap);

        // 控制： 只要你获取过这个key。 就把这个key取出来放在最后。
        System.out.println("linkedHashMap.get(\"ls\") = " + linkedHashMap.get("ls"));

        System.out.println(linkedHashMap);

        // 有什么用？
        // 放在最前面的东西，一定是很久没有被访问过的。 可以优先删除这些数据。
    }

}

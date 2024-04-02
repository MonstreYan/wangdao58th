package com.cskaoyan._20map._01introduct;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Common-zhou
 * @since 2024-04-02 15:03
 */
public class Demo2Feature {
    @Test
    public void test1() {
        // 1. Map存储的数据，有一些子实现有序，有一些无序。 大家学完之后，需要梳理一下，哪些有序，哪些无序。
        // 2. Map存储的数据，不能重复（指的是key）
        // 3. Map存储的数据，有一些允许为null，有一些不允许。（指的key）

        // HashMap是无序的 LinkedHashMap
        // Map<String, Integer> map = new HashMap<>();
        // Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> map = new TreeMap<>();

        map.put("zs", 18);
        map.put("jingtian", 19);
        map.put("changxu", 17);
        map.put("yali", 16);

        System.out.println(map);

    }

    @Test
    public void test2() {
        // 2. Map存储的数据，不能重复（指的是key）
        // 3. Map存储的数据，有一些允许为null，有一些不允许。（指的key）

        // Map<String, String> map = new TreeMap<>();
        Map<String, String> map = new HashMap<>();

        map.put("jingtian", "茶颜悦色");
        map.put("changxu", "肥宅快乐水");
        map.put("yali", "ad钙");
        map.put("kongling", "蜜雪冰城");

        map.put(null, "七分甜");

        System.out.println(map);
        map.put("kongling", "肥宅快乐水");

        System.out.println(map);
    }

    @Test
    public void test3() {
        // Map打印出来的数据。张什么样？
        // toString方法都被重写过。

        // toString、 equals、hashCode。
    }
}

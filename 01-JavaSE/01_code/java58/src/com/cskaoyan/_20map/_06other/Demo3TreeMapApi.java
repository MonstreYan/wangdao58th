package com.cskaoyan._20map._06other;

import org.junit.Test;

import java.util.*;

/**
 * @author Common-zhou
 * @since 2024-04-05 16:23
 */
public class Demo3TreeMapApi {
    @Test
    public void test1() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(8, "ba");
        treeMap.put(7, "qi");
        treeMap.put(3, "san");
        treeMap.put(1, "yi");
        treeMap.put(6, "liu");
        treeMap.put(2, "er");

        //                     6
        // {1=yi, 2=er, 3=san, 6=liu, 7=qi, 8=ba}
        System.out.println(treeMap);

        // Entry   就是键和值的组合体。
        // key  就是里面的键。

        //        Map.Entry<K,V> ceilingEntry(K key): 大于等于给定key的最小键值对
        //        K ceilingKey(K key): 大于等于给定key的最小key

        // 往上找，找到一个最小的。 ceilingEntry 带等于
        Map.Entry<Integer, String> entry = treeMap.ceilingEntry(4);
        System.out.println(entry.getKey() + "___" + entry.getValue());
        Map.Entry<Integer, String> entry1 = treeMap.ceilingEntry(7);
        System.out.println(entry1.getKey() + "___" + entry1.getValue());

        System.out.println("treeMap.ceilingKey(7) = " + treeMap.ceilingKey(7));
    }


    @Test
    public void test2() {
        //        NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
        //        返回此映射的部分视图，其键的范围从 fromKey 到 toKey。

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(8, "ba");
        treeMap.put(7, "qi");
        treeMap.put(3, "san");
        treeMap.put(1, "yi");
        treeMap.put(6, "liu");
        treeMap.put(2, "er");

        // {1=yi, 2=er, 3=san, 6=liu, 7=qi, 8=ba}
        // [3,8)
        SortedMap<Integer, String> sortedMap = treeMap.subMap(3, 8);

        System.out.println(sortedMap);

        NavigableMap<Integer, String> navigableMap = treeMap.subMap(3, true, 8, true);


        Set<Map.Entry<Integer, String>> entries = navigableMap.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "___" + entry.getValue());
        }

    }

    @Test
    public void test3() {
        // TreeMap有什么用？

        // 需要键值对两个东西。
        // key是Date。  value是 天气。
        // 现在需要你输入前十天的天气预报。 依次遍历10个。

        // 1.需要key-value
        // 2.需要有序。

        // 可以用TreeMap。能不能用其他的完成？

        // HashMap。  + ArrayList.(sort)
    }


    @Test
    public void test4() {
        // 要了解 ArrayList和HashMap的常见操作，时间复杂度。

        List<String> list = new ArrayList<>();
        // O(1)
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");

        list.add(0, "666");

        // contains的时间复杂度 O(1)
        list.contains("zs");

        int zs = list.indexOf("zs");
    }
}

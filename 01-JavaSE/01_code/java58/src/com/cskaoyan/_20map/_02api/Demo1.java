package com.cskaoyan._20map._02api;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Common-zhou
 * @since 2024-04-02 15:12
 */
public class Demo1 {

    //---------------------------新增，删除，查找数据接口
    //    void putAll(Map<? extends K,? extends V> m)： 将一个map的所有键值对都放入这个map

    @Test
    public void test1() {
        //    V put(K key, V value): 添加键值对。 如果键存在，是更新数据
        // 增和改都是使用put方法。 如果之前不存在这个数据，则是新增； 之前存在这个数据，就是修改。
        // 所说的是key。

        // 这个Map。 是存储的这个人 所住的地址。
        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println(map);
        map.put("景天", "内蒙古");
        System.out.println(map);
    }

    @Test
    public void testRemove() {
        //    V remove(Object key)： 删除map中所包含的这个key
        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println(map);
        String oldValue = map.remove("空灵");
        System.out.println(oldValue);
        System.out.println(map);
    }

    @Test
    public void test3Get() {
        //    V get(Object key)： 根据一个key，获取value，如果key不存在，返回null
        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println("map.get(\"景天\") = " + map.get("景天"));

        System.out.println("map.get(\"娅骊\") = " + map.get("娅骊"));
    }

    @Test
    public void test4Contains() {
        //    boolean containsKey(Object key): 判断map中是否包含这个key
        //    boolean containsValue(Object value): 判断map中是否包含这个value

        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println("map.containsKey(\"景天\") = " + map.containsKey("景天"));

        System.out.println("map.containsKey(\"洋洋\") = " + map.containsKey("洋洋"));

        System.out.println("map.containsValue(\"湖北\") = " + map.containsValue("湖北"));
    }

    @Test
    public void testGetOrDefault() {
        // getOrDefault()
        // 如果存在，就返回对应的值；  如果不存在，就返回默认值
        // get()   根据一个key，获取value，如果key不存在，返回null
        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println("map.getOrDefault(\"王鑫\", \"中国\") = " + map.getOrDefault("王鑫", "中国"));

        System.out.println("map.getOrDefault(\"洋洋\", \"中国\") = " + map.getOrDefault("洋洋", "中国"));

    }


    @Test
    public void testOther() {
        //---------------------------辅助接口
        //    void clear() : 清空map
        //    boolean equals(Object o)： 判断两个map是否相等
        //    int hashCode(): 返回此映射的哈希码值。
        //    boolean isEmpty(): map中是否有元素
        //    int size() ：返回键-值映射关系数。

        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        System.out.println(map.size());
    }
}

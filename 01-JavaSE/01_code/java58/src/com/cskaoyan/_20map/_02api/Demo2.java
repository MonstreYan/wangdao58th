package com.cskaoyan._20map._02api;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Common-zhou
 * @since 2024-04-02 15:25
 */
public class Demo2 {

    @Test
    public void test1() {
        //---------------------------视图方法。  遍历方法
        // 在Map里面 Entry 代表存储了key和value的一个接口体
        //    Set<Map.Entry<K,V>> entrySet()： 返回此映射中包含的映射关系的 Set 视图。

        //    Collection<V> values()： 返回此映射中包含的值的 Collection 视图。

        // entry是什么东西。entry在Map中，是键和值的组合体。 你可以从entry中，拿到key，也可以拿到value。

        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        // Set<Map.Entry<String, String>> ma

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "___" + entry.getValue());
        }

    }

    @Test
    public void test2() {
        //    Set<K> keySet()： 返回此映射中包含的键的 Set 视图。
        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");

        Set<String> keySet = map.keySet();

        for (String s : keySet) {
            System.out.println(s);
            String value = map.get(s);
            System.out.println(value);
        }
    }


    @Test
    public void test3() {
        //    Collection<V> values()： 返回此映射中包含的值的 Collection 视图。

        Map<String, String> map = new HashMap<>();

        map.put("景天", "河南");
        map.put("空灵", "湖北");
        map.put("王鑫", "内蒙古");
        map.put("常旭", "内蒙古");


        Collection<String> values = map.values();

        for (String value : values) {
            System.out.println(value);
        }
    }
}

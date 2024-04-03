package com.cskaoyan._20map._05hashmap;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Common-zhou
 * @since 2024-04-03 10:30
 */
public class Demo1 {
    @Test
    public void test1() {
        // HashMap的底层结构，是数组 + 链表 + 红黑树

        // key是人名，value是年龄
        HashMap<String, Integer> map = new HashMap<>();

        map.put("zs", 18);
        map.put("jingtian", 19);
        map.put("changxu", 17);
        map.put("chenjian", 17);
    }


    @Test
    public void test2() {
        // 如果存储重复数据，是怎样操作的？
        HashMap<String, Integer> map = new HashMap<>();

        map.put("zs", 18);
        // 如果存储重复元素。 怎么操作的？
        // 使用新值，将旧值替代。

        map.put("zs", 20);
    }
}

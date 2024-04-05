package com.cskaoyan._20map._05hashmap;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Common-zhou
 * @since 2024-04-05 17:25
 */
public class Demo5HashMapSourceCode {
    @Test
    public void test1() {
        // 1.HashMap底层是个数组。 数组长度16；
        // 2.扩容机制， 2倍。

        HashMap<String, String> map = new HashMap<>();

        map.put("zs", "hubei");
        map.put("ls", "hunan");

    }
}

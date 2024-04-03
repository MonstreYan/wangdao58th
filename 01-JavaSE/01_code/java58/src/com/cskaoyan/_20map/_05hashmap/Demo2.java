package com.cskaoyan._20map._05hashmap;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Common-zhou
 * @since 2024-04-03 11:08
 */
public class Demo2 {
    @Test
    public void test1() {
        // HashMap的底层是数组 + 链表 + 红黑树。
        // 数组的默认长度是16，扩容机制2倍
        HashMap<String, String> map = new HashMap<>();

        // 在构造方法里面，没有见到数组的初始化，在哪里，一定会见到数组的初始化？
        // 添加的时候
        map.put("zs", "hubei");


        // loadFactor能调。
        // loadFactor控制的其实是数据的密度。  3/4有数据就会扩容
        // 需不需要我们自己调。
        // loadFactor一般不需要调。 因为这种基础数据，JDK的官方肯定是结合了大量的工程实践，测出来的。
    }


    @Test
    public void test2() {
        // HashMap中，到底怎样认为是重复的。

        HashMap<String, String> map = new HashMap<>();
        map.put("zs", "hubei");
        map.put("ls", "hubei");
        map.put("wu", "hubei");
        map.put("zs", "hubei");


        // HashMap底层，到底怎么认为两个键重复。
        HashMap<User, String> map2 = new HashMap<>();
        map2.put(new User(), "123");


    }
}


class User {

}

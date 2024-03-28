package com.cskaoyan._18generic.d07_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-03-28 10:28
 */
public class Demo2 {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        // list.add(10);

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(12);
        // list1.add("zs");

        // 泛型是跟着对象一起走的。 对象声明的时候能装什么类型，就能装什么类型。


    }
}

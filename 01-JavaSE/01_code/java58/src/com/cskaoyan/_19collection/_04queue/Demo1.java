package com.cskaoyan._19collection._04queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Queue叫做队列。 在Java中，这玩意是个接口。
 *
 * @author Common-zhou
 * @since 2024-04-01 17:21
 */
public class Demo1 {
    @Test
    public void test1() {
        // 左边是接口，右边是子实现类。
        //
        Queue<String> queue = new ArrayDeque<>();
    }


    @Test
    public void test2() {
        // 1. 存储元素有序
        // 2. 存储元素可重复
        // 3. 不能存储null（除了LinkedList子实现）

        Queue<String> queue = new ArrayDeque<>();

        queue.add("zs");
        queue.add("ls");
        queue.add("zl");
        queue.add("wu");
        queue.add("zl");

        queue.add(null);

        System.out.println(queue);

    }

}

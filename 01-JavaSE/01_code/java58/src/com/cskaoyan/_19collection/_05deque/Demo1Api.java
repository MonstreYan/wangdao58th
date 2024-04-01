package com.cskaoyan._19collection._05deque;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Common-zhou
 * @since 2024-04-01 17:51
 */
public class Demo1Api {
    @Test
    public void test1() {
        Deque<String> deque = new LinkedBlockingDeque<>(3);

        deque.offerFirst("zs");
        deque.offerFirst("ls");
        deque.offerFirst("wu");
        deque.offerFirst("zl");

        System.out.println(deque);
    }

    @Test
    public void test2() {
        // 1.使用Deque接口API的时候，可以画个图。
        // 可以用注释来画图。

        Deque<String> deque = new ArrayDeque<>();
        // first               last
        //  ls    zs   123   987

        deque.addFirst("zs");
        deque.addFirst("ls");
        deque.offerLast("123");
        deque.offerLast("987");

        System.out.println("deque.pollFirst() = " + deque.pollFirst());
    }

    @Test
    public void test3() {
        // 2.使用成套使用，不要自己为难自己。
        ArrayDeque<String> deque = new ArrayDeque<>();

        // offerLast  offerFirst peekFirst peekLast
        // offer poll peek
        // pop push
        //
        deque.offerLast("zs");
        deque.offer("ls");
        deque.push("ooo");
        deque.addLast("888");


        // 使用API的时候，一套一套用。
        System.out.println("deque.pop() = " + deque.pop());

        // 底下就是个数组。
        // 不同的操作，往不同的位置插入，删除。

    }

}

package com.cskaoyan._19collection._05deque;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Common-zhou
 * @since 2024-04-02 10:12
 */
public class Demo2DequeAsStackAndQueue {

    @Test
    public void test1AsStack() {
        // 队列的API。
        // Queue
        // 两组。 一组三个。  添加、删除、查看但是不删除。
        // add remove element
        // offer poll peek

        // 两组API的区别，极端情况的表现不一样。
        // 第一组，在极端情况报错
        // 第二组，在极端情况返回特殊值。


        // 双端队列的API。
    }

    @Test
    public void test2AsStack() {
        // 双端队列，怎么作为一个栈。用它内部API，怎么实现一个栈？

        Deque<String> stack = new ArrayDeque<>();

        // stack.push();
        // stack.pop();
        // stack.peek();

        Deque<String> stack1 = new ArrayDeque<>();
        stack1.offerFirst("zs");
        stack1.offerFirst("ls");
        stack1.offerFirst("wu");

        System.out.println("stack1.pollFirst() = " + stack1.pollFirst());
        System.out.println("stack1.pollFirst() = " + stack1.pollFirst());
        System.out.println("stack1.pollFirst() = " + stack1.pollFirst());

        // 从first端进，从first端出
        // 从last端进，从last端出
        Deque<String> stack2 = new ArrayDeque<>();
        stack2.offerLast("lll");
        stack2.offerLast("mmm");
        stack2.offerLast("nnn");

        System.out.println("stack2.pollLast() = " + stack2.pollLast());
        System.out.println("stack2.pollLast() = " + stack2.pollLast());
        System.out.println("stack2.pollLast() = " + stack2.pollLast());
        System.out.println("stack2.pollLast() = " + stack2.pollLast());

    }

    @Test
    public void test3AsStack() {
        ArrayDeque<String> stack1 = new ArrayDeque<>();

        stack1.push("zs");
        stack1.pop();
    }

    @Test
    public void test4AsQueue() {
        // 队列。操作受限的线性表， 从一端进，从另一端出。
        // first   last
        // last进  first出

        // 用API的时候，成对使用，不要自己为难自己。

    }

}

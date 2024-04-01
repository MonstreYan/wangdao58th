package com.cskaoyan._19collection._03list._03subclass;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Common-zhou
 * @since 2024-04-01 17:05
 */
public class Demo5Stack {
    @Test
    public void test1() {

        // Stack是线程安全的，效率不高。
        // 不建议使用。
        // 如果要用栈这个结构，推荐使用Deque接口。

        // Java的向前兼容。
        Stack<String> stack = new Stack<>();

        stack.push("zs");
        stack.push("ls");
        stack.push("wu");

        // 栈： 先进后出。 只能从同一端进出。
        // 队列： 先进先出。 只能从一端进，只能从另一端出。

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());

        Deque<Integer> stack2 = new ArrayDeque<Integer>();

        // stack2.push();
        // stack2.pop();
    }
}

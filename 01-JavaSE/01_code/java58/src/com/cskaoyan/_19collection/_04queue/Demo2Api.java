package com.cskaoyan._19collection._04queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Common-zhou
 * @since 2024-04-01 17:28
 */
public class Demo2Api {

    @Test
    public void test1() {
        // Queue是Collection的子接口。
        // Collection里面有的方法，Queue里面有没有？

        // Queue是什么东西？ 是队列。 操作受限的线性表。

        Queue<String> queue = new ArrayDeque<>();

        // zs    ls    wu   zl
        queue.add("zs");
        queue.add("ls");
        queue.add("wu");
        queue.add("zl");

        //1.操作能否成功   . 成功了
        // 2.应不应该这么写？不应该。
        System.out.println(queue);
        queue.remove("ls");
        System.out.println(queue);

        // 如果使用Queue接口。不要用这些。 remove(element)
    }

    @Test
    public void test2() {
        // Queue接口里面两组API。 在极端情况下表现不一样。
        //boolean add(E e): 将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException。
        // E remove():获取并移除此队列的头。
        //E element() :获取，但是不移除此队列的头。

        Queue<String> queue = new ArrayDeque<>();

        queue.add("zs");
        queue.add("ls");
        queue.add("wu");

        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.remove() = " + queue.remove());

        System.out.println("queue.element() = " + queue.element());
        System.out.println("queue.element() = " + queue.element());
        System.out.println("queue.element() = " + queue.element());
        System.out.println("queue.element() = " + queue.element());
    }

    @Test
    public void test3() {
        //boolean offer(E e):将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
        //E poll():获取并移除此队列的头，如果此队列为空，则返回 null。
        //E peek(): 获取但不移除此队列的头；如果此队列为空，则返回 null。

        Queue<String> queue = new ArrayDeque<>();

        queue.offer("zs");
        queue.offer("ls");
        queue.offer("wu");

        System.out.println("queue.poll() = " + queue.poll());

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
    }

    @Test
    public void test4() {
        // 在极端情况下，表现不一样。
        // 满了的时候，添加数据
        // 空了的时候，删数据， 查看数据。

        // add remove  element 极端情况下报错
        // offer poll peek 极端情况下，返回特殊值

        Queue<String> queue = new LinkedBlockingQueue<>(3);

        queue.add("zs");
        queue.add("ls");
        queue.add("wu");
        // queue.add("zl");

        System.out.println(queue);

        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println("queue.remove() = " + queue.remove());
        // System.out.println("queue.remove() = " + queue.remove());

        System.out.println("queue.element() = " + queue.element());

    }


    @Test
    public void test5() {
        // offer poll peek 极端情况下，返回特殊值

        Queue<String> queue = new LinkedBlockingQueue<>(3);

        System.out.println("queue.offer(\"zs\") = " + queue.offer("zs"));
        System.out.println("queue.offer(\"ls\") = " + queue.offer("ls"));
        System.out.println("queue.offer(\"wu\") = " + queue.offer("wu"));
        System.out.println("queue.offer(\"wu\") = " + queue.offer("wu"));

        System.out.println(queue);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        // System.out.println("queue.poll() = " + queue.poll());
        // System.out.println("queue.poll() = " + queue.poll());
        // System.out.println("queue.poll() = " + queue.poll());

        System.out.println("queue.peek() = " + queue.peek());

    }

}

package com.cskaoyan._19collection._05deque;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-04-02 11:54
 */
public class Demo4BlockingQueue {
    @Test
    public void test1() throws InterruptedException {
        // 阻塞队列。 在极端情况会阻塞。 但是阻塞的API，只有两类会阻塞。
        // put take 才会阻塞
        // offer poll 有时间的阻塞。

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("zs");
        blockingQueue.put("ls");
        blockingQueue.put("wu");
        // System.out.println("开始");
        // blockingQueue.put("wu");
        // System.out.println("结束");


        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        // System.out.println("blockingQueue.take() = " + blockingQueue.take());
    }

    @Test
    public void test2() throws InterruptedException {
        // offer和poll。就是带超时时间的阻塞。 在时间内，会阻塞，超过时间，会停止。
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("zs", 2, TimeUnit.SECONDS);
        blockingQueue.offer("ls", 2, TimeUnit.SECONDS);
        blockingQueue.offer("wu", 2, TimeUnit.SECONDS);

        System.out.println("开始");
        blockingQueue.offer("666", 2, TimeUnit.SECONDS);
        System.out.println("结束");
    }
}

package com.cskaoyan._13thread._11product_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Common-zhou
 * @since 2024-03-23 10:25
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("zs");
        blockingQueue.put("ls");
        blockingQueue.put("wu");

        System.out.println(blockingQueue);

        // blockingQueue.put("wu");
        // System.out.println(blockingQueue);

        // 阻塞队列： 在极端情况下，会阻塞。
        // 满了，空了。    满了，再往里面塞数据，阻塞； 空了的时候，再从里面掏数据，阻塞。


        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        // System.out.println("blockingQueue.take() = " + blockingQueue.take());


        // 阻塞队列。可以用来解决。 生产者和消费者  速率不匹配问题。
    }
}

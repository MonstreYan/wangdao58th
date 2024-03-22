package com.cskaoyan._13thread._11product_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模型
 * <p>
 * Java里面提供了一个类。   BlockingQueue ： 阻塞队列
 * <p>
 * 1.当队列满了，添加会阻塞
 * 2.当队列空了，删除会阻塞
 *
 * @author Common-zhou
 * @since 2024-03-22 17:46
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

        // 队列： 先进先出。

        blockingQueue.put("1");
        blockingQueue.put("2");
        blockingQueue.put("3");
        blockingQueue.put("4");
        blockingQueue.put("5");
        // blockingQueue.put("6");

        System.out.println(blockingQueue);

        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());

        System.out.println("blockingQueue.take() = " + blockingQueue.take());

        // 可以用阻塞队列，来完成生产者 消费者模型。

    }

}

package com.cskaoyan._13thread._11product_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * 生产者和消费者，就是通过  BlockingQueue将速率匹配上。
 *
 * @author Common-zhou
 * @since 2024-03-23 10:31
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(blockingQueue));

        Thread consumer = new Thread(new Consumer(blockingQueue));

        producer.start();

        TimeUnit.SECONDS.sleep(5);

        consumer.start();

        // 线程安全的。
    }
}

// 生产者。生产包子的
class Producer implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                String name = "包子-" + i;
                blockingQueue.put(name);
                System.out.println("生产了包子：" + name);

                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Consumer implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            String name = null;
            try {
                name = blockingQueue.take();
                System.out.println("常旭同学拿到包子了：" + name);

                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

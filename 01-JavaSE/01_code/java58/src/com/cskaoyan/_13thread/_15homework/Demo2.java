package com.cskaoyan._13thread._15homework;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个可自由扩容的线程池，然后向线程池提交十个任务
 * 这十个任务中的每个任务都会随机睡眠0-10s，睡眠结束后打印睡眠时间就结束任务
 * 请完成这个线程池语法练习题
 *
 * @author Common-zhou
 * @since 2024-03-25 10:22
 */
public class Demo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10);
                    try {
                        // Thread.sleep(randomNumber * 1000);
                        TimeUnit.SECONDS.sleep(randomNumber);
                    } catch (InterruptedException e) {
                        System.out.println("发生异常了");
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程执行结束了");
                }
            });
        }

        // 关闭线程池。
        // 有任务正在执行怎么办？
        // 调用了shutdown之后。 就无法再往线程池里面放新的任务。
        // 之前正在执行的任务， 我给你打个招呼。 给你报个异常。 InterruptedException

        // shutdown 等它执行完了。shutdownNow让里面的报错。
        executorService.shutdownNow();
        // executorService.shutdown();

        // 一般情况下，我们不会自己手动关。
        // 框架一般会自动完成收尾工作。

    }
}



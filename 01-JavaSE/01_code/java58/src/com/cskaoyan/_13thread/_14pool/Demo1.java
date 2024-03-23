package com.cskaoyan._13thread._14pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-23 11:40
 */
public class Demo1 {
    public static void main(String[] args) {
        // Executors: 线程工具类, 负责产生线程池
        // ExecutorServices: 代表线程池对象

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        }



    }
}

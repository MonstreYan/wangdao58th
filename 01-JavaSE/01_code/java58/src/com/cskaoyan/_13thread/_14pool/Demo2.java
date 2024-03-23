package com.cskaoyan._13thread._14pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Common-zhou
 * @since 2024-03-23 11:43
 */
public class Demo2 {
    public static void main(String[] args) {
        // 阿里的开发手册。 线程池那里。禁止使用 Executors。 建议直接
        // new ThreadPoolExecutor（）

        // 主要里面有一段执行逻辑。
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // ThreadPoolExecutor 就是Java原生提供的一个线程池。
        // Executors是个工具类。 它是想帮你快捷的创建一个线程池。 但是有点问题、


        // new ThreadPoolExecutor(nThreads, nThreads,
        //                                       0L, TimeUnit.MILLISECONDS,
        //                                       new LinkedBlockingQueue<Runnable>());

        // new ThreadPoolExecutor()
        // corePoolSize
        // maxmuimPoolSize
        // keepAliveTime
        // timeUnit
        // BlockingQueue
        // RejectExecutionHandler

        String s = "hello";
        StringBuilder s1 = new StringBuilder("hello");

        System.out.println("s1.equals(s) = " + s1.equals(s));


    }
}

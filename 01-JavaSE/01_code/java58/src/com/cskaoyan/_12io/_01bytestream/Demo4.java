package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-20 11:04
 */
public class Demo4 {
    @Test
    public void test1() {
        // 为啥要close。程序一跑代码，就结束了。然后方法直接退出了。JVM也退出了。JVM都退出了，这些资源肯定会关掉。
        // 为什么要close？

        // 因为进入企业中，你会发现，你的程序不会挂掉。 会一直跑。
        // 银行的一些系统的时候。  它的程序一定一直在那跑
        // 淘宝。 7*24小时一直不间断的在跑。
    }
}

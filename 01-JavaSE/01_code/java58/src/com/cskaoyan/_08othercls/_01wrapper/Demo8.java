package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 17:49
 */
public class Demo8 {
    @Test
    public void test1() {
        // 包装类的使用场景还是比较多的，最常见的：
        // 1. 包装类把基本数据类型变为一个对象，并且存在自动拆装箱，有些时候这本身就是一个用途
        // 2. 集合当中使用，集合只能存储对象，所以集合中就要用包装类型替代基本数据类型
        // 3. 获取一些最值之类的常量。（Integer.MAX_VALUE）
        // 4. 做进制转换，类型转换等操作(Integer.parseInt("777", 8);)
        // 5. 后续做项目, 写接口的时候也建议使用包装类型(需要判断null)

        // radix 基数
        int i = Integer.parseInt("123", 8);
        System.out.println(i);
        // 123如果是8进制。   3 + 2 * 8 + 1*64 =


    }
}

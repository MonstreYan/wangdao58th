package com.cskaoyan._19collection._03list._03subclass;

import org.junit.Test;

import java.util.Vector;

/**
 * @author Common-zhou
 * @since 2024-04-01 16:40
 */
public class Demo4Vector {
    @Test
    public void test1() {
        Vector<String> vector = new Vector<>();

        vector.add("zs");
        vector.add("ls");
        vector.add("wu");

        vector.remove("111");

        // vector里面的方法，都加了synchronized关键字，用来保证线程安全。
        // 所以效率比较差。
        // 多线程，在日常工作过程中。使用不多。 所以JDK在1.2的时候，推出了 ArrayList这个线程不安全的容器。
    }
}

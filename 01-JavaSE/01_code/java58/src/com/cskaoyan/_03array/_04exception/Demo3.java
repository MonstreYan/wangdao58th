package com.cskaoyan._03array._04exception;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 11:49
 */
public class Demo3 {
    @Test
    public void test1() {
        // 空指针异常。 就是在程序中。 如果使用了null去点一些属性，或者使用一些方法， 这时候会出空指针。
        // String str = "hello";
        String str = null;

        System.out.println("str.length() = " + str.length());
        System.out.println("str.toLowerCase() = " + str.toUpperCase());
    }

    @Test
    public void test2() {
        // 所以大家今后在写代码的时候。 要注意哪些地方可能为null。需要防着点。
    }

    @Test
    public void test3() {
        // JDK8. 在空指针这块。 没啥提示信息。
        // JDK内部，在高版本的时候，专门对空指针这里的提示做了改进。 所以用的时候，注意一下区别即可
        String str = null;

        System.out.println("str.length() = " + str.length());

    }

}

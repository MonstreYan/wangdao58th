package com.cskaoyan._03array._02memory;

import org.junit.Test;

/**
 * 不管赋值方式有多少种，第一步永远是默认初始化。
 *
 * @author Common-zhou
 * @since 2024-03-04 11:07
 */
public class Demo9Allocate {

    @Test
    public void test1() {
        // 我们都知道数组的静态初始化，是直接给出数组对象的元素值。
        // 那么元素的值就是直接赋我们给出的具体值吗？
        // 结合上面，显然不是，必须先默认初始化，具有默认值，然后才能赋其它具体值。
        int[] nums = {1, 2, 3};

        // 不管赋值方式有多少种，第一步永远是默认初始化。
    }

    @Test
    public void test2() {
        // 只要是引用数据类型，都存储的是地址。
        String[] teasList = {"茶百道", "书亦烧仙草", "蜜雪冰城"};
        // 1.在任任何赋值方式之前，永远是默认初始化
        // 2.在数组中，如果数组存储的是引用数据类型，这里存储的一定是引用数据类型的地址。


    }

}

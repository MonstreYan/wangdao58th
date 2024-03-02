package com.cskaoyan._03array._01define;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-02 11:03
 */
public class Demo6Other {
    @Test
    public void test1() {
        // 数组元素的获取和赋值都依赖于下标访问，本质上是一个语法:
        // 数组名[下标] = 值;
        String[] teaList = {"霸王茶姬", "茶百道", "沪上阿姨", "瑞幸", "星巴克"};

        System.out.println("Arrays.toString(teaList) = " + Arrays.toString(teaList));
        teaList[1] = "KFC";

        // 想打印内容。  Arrays.toString()
        System.out.println(teaList);

        System.out.println("Arrays.toString(teaList) = " + Arrays.toString(teaList));

    }

    @Test
    public void test2() {
        // 获取数组的长度
        String[] teaList = {"霸王茶姬", "茶百道", "沪上阿姨", "瑞幸", "星巴克"};

        int length = teaList.length;

        System.out.println(length);
    }

    @Test
    public void test3() {
        // 怎么遍历数组。
        // 遍历： 访问并且仅访问所有数据一次。
        String[] teaList = {"霸王茶姬", "茶百道", "沪上阿姨", "瑞幸", "星巴克"};

        // System.out.println(teaList[0]);
        // System.out.println(teaList[1]);
        // System.out.println(teaList[2]);
        // System.out.println(teaList[3]);
        // System.out.println(teaList[4]);

        // 循环。 fori
        int length = teaList.length;
        // 0 1  2 3 4 length-1
        for (int i = 0; i < length; i++) {
            System.out.println(teaList[i]);
        }

    }
}

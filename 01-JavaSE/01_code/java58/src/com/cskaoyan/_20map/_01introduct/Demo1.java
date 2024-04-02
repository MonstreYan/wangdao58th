package com.cskaoyan._20map._01introduct;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 110 是警察局
 * 120 是医院
 * 119 是火警
 * 122 是车辆救援
 * 12345 是消费者权益保护
 *
 * @author Common-zhou
 * @since 2024-04-02 14:40
 */
public class Demo1 {
    @Test
    public void test1() {
        // 如果不用Map。 可以怎么实现？

        // 可以用一个类，类里面存电话、机构名
        // 我想找110对应的机构。
        // 遍历这个集合。 电话如果是110的话。 就找到对应的结构了。
    }


    @Test
    public void test2() {
        // Map就是存储键值对的一个集合。 它支持存储key-value进去，然后支持根据key获取value
        Map<String, String> map = new HashMap<>();


        // 110 是警察局
        // 120 是医院
        // 119 是火警
        // 122 是车辆救援
        // 12345 是消费者权益保护

        // Expected 2 arguments but found 1
        map.put("110", "警察局");
        map.put("120", "医院");
        map.put("119", "火警");
        map.put("122", "车辆救援");
        map.put("12345", "消费者权益保护");

        System.out.println("map.get(\"110\") = " + map.get("110"));

        // Graph

    }


    @Test
    public void test3() {
        // 比如，如果我们想在1-20中间随机生成10000个数，需要记录每个数生成了多少次，怎么存呢？

        // 可以使用数组来做这个需求。
        // 当前生成了这个数多少次。
        int[] generateNums = new int[21];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // random.nextInt(20) + 1
            // [0,19] + 1
            int randomNumber = random.nextInt(20) + 1;

            generateNums[randomNumber]++;
        }

        System.out.println(Arrays.toString(generateNums));
    }

    @Test
    public void test4() {
        // 怎么随机生成 [m,n]之间的数

        // [0, n-m]  + m
        // [m, n]
        // random.nextInt(n - m + 1) + m
    }
}

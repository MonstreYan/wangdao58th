package com.cskaoyan._20map._02api;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Common-zhou
 * @since 2024-04-02 15:48
 */
public class Demo3Example {
    @Test
    public void test1() {
        // 如果我们想在1-20中间随机生成10000个数。怎么存？
        // 使用Map，就需要考虑一个问题。 键是什么，值是什么。
        // 键和值，可以怎样组合，完成我的需求。

        // 键是什么？值是什么？
        // 键是随机生成的数； 值是生成的次数。
        Map<Integer, Integer> map = new HashMap<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = random.nextInt(20) + 1;

            // 现在在这一行。map中有没有？
            if (map.containsKey(randomNumber)) {
                Integer count = map.get(randomNumber);
                // 说明，之前生成过。
                map.put(randomNumber, count + 1);
            } else {
                map.put(randomNumber, 1);
            }
        }
        System.out.println(map);
    }


    @Test
    public void test2() {
        // Map代表。 key是这个数，value是生成的次数。
        Map<Integer, Integer> map = new HashMap<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // 循环10000次。
            // 1.生成随机数。
            int randomNumber = random.nextInt(20) + 1;
            // 2.存储起来。 它生成了多少次。
            // 生成了一个随机数， 有几种情况。
            // 1）之前生成过。 现在是第n次生成。
            // 2） 之前没生成过，现在是第一次生成。
            if (map.containsKey(randomNumber)) {
                Integer count = map.get(randomNumber);
                map.put(randomNumber, count + 1);
            } else {
                map.put(randomNumber, 1);
            }
        }
        System.out.println(map);
    }


    @Test
    public void test3() {
        // Map代表。 key是这个数，value是生成的次数。
        Map<Integer, Integer> map = new HashMap<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = random.nextInt(20) + 1;

            // Integer count = map.get(randomNumber);
            // // count有几种情况。 null； 有值。
            // if (count == null) {
            //     count = 0;
            // }

            Integer count = map.getOrDefault(randomNumber, 0);
            map.put(randomNumber, count + 1);

            // 写代码不要这么精简。 要保证可读性。
            // map.put(randomNumber, map.getOrDefault(randomNumber, 0) + 1);

        }
        System.out.println(map);
    }
}

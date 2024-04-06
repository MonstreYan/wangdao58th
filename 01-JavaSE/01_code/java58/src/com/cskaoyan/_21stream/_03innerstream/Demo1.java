package com.cskaoyan._21stream._03innerstream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Common-zhou
 * @since 2024-04-06 11:07
 */
public class Demo1 {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>(Arrays.asList("zs", "ls", "wu", "zl"));

        Stream<String> sorted = list.stream().sorted();

        System.out.println(sorted);

        // 必须要中止操作之后。才能看到数据。
    }

    @Test
    public void test2() {
        // 这两个中止操作先掌握，因为要看中间操作的结果。
        // count(): 流里面有多少元素，最终会返回Long类型。
        // collect(Collectors.toList())： 将流里面的元素，存储为一个List;

        List<String> list = new ArrayList<>(Arrays.asList("zs", "ls", "wu"));

        long count = list.stream().sorted().count();
        System.out.println(count);


        List<String> collect = list.stream().sorted().collect(Collectors.toList());

        System.out.println(collect);
    }
}

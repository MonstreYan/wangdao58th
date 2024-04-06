package com.cskaoyan._21stream._02beginstream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建流的方式
 * 1.直接使用集合类.stream() 方法。 生成流
 * 2.直接有值创建。 Stream.of()
 *
 * @author Common-zhou
 * @since 2024-04-06 10:57
 */
public class Demo1 {
    @Test
    public void test1() {
        Collection<String> collection = new ArrayList<>();

        Stream<String> stream = collection.stream();

        // 生成流之后。不能分叉处理。

        List<String> list1 = stream.sorted().collect(Collectors.toList());
        // List<String> list2 = stream.sorted().collect(Collectors.toList());

        // 今后写流的代码。
        // collection.stream().sorted().limit(3).distinct().collect(Collectors.toList());
    }


    @Test
    public void test2() {
        Stream<String> stringStream = Stream.of("zs", "ls", "wu", "zl");

        List<String> collect = Stream.of("zs", "ls", "wu", "zl").collect(Collectors.toList());

        System.out.println(collect);
    }


    @Test
    public void test3() {
        // 1.生成流之后，不能分叉处理
        // 2.生成了流，处理（筛选、截取），是否影响之前的集合？ ==> 不影响。
        // 生成流，只是提供数据源，不会影响之前的数据。
        List<String> list = new ArrayList<>(Arrays.asList("zs", "ls", "wu", "zl"));

        List<String> collect = list.stream().limit(2).collect(Collectors.toList());


    }
}

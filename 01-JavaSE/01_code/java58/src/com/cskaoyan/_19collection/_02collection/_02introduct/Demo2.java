package com.cskaoyan._19collection._02collection._02introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 开发一时爽，一直开发一直爽。
 * 开发一时爽，  维护火葬场。
 *
 * @author Common-zhou
 * @since 2024-03-29 10:08
 */
public class Demo2 {
    @Test
    public void test1() {
        // 集合类，其实就是Java帮我们封装的一些类。
        // 可以使用这些类，完成功能。底层帮我们屏蔽了非常多细节。 减少了我们写代码过程中会出现的bug。

        // Collection： 存储的单列数据。 一个一个的数据。 比如一个一个的学生，一个一个的字符串
        // Collection其实就是接口。 不能直接new， 我们选用了一个实现类。 ArrayList。 底层是数组。
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zl");

        // [zs, ls, wu, zl] : 说明toString方法被重写过。
        System.out.println(collection);

    }

    @Test
    public void test2() {
        // Map： 存储的是双列数据。
        // 存储的是一对一对的数据。 存储的是key-value数据。
        // Map也是个接口。 存储key-value数据。 声明的时候，需要传入两个泛型。 分别是key的类型，value的类型。
        // 根据key，找value。
        // Map最大的作用，就是存储key-value数据； 然后根据key，找value。
        Map<String, String> map = new HashMap<>();

        map.put("景天", "茶颜悦色");
        map.put("空灵", "蜜雪冰城");

        String s = map.get("景天");
        System.out.println(s);

    }
}

package com.cskaoyan._19collection._04api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Common-zhou
 * @since 2024-03-29 15:58
 */
public class Demo5Foreach {
    @Test
    public void test1() {
        // Collection中也有foreach

        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zl");

        // foreach就是一个简化写法。
        // 其实底层还是 iterator.
        for (String element : collection) {
            System.out.println(element);
            // foreach的底层是个迭代器。 所以在使用foreach的时候，不能对原有集合进行修改。
            // collection.add("zs");
        }

    }
}

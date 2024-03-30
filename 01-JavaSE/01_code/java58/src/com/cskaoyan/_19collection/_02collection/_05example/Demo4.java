package com.cskaoyan._19collection._02collection._05example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1.集合的遍历方式有哪些？
 * 这几种遍历方式，一定要会。
 * Collection.
 * 1) 迭代器
 * 2）foreach
 * 3)toArray
 *
 * @author Common-zhou
 * @since 2024-03-29 17:27
 */
public class Demo4 {

    @Test
    public void test1() {
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zl");
        // 1) 迭代器

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();

            System.out.println(next);
        }


    }

    @Test
    public void test2() {
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zl");

        for (String s : collection) {
            System.out.println(s);
            // collection.remove("zs");
        }

        // foreach的底层是用。iterator。
        // iterator。需要注意的点。 在使用迭代器的时候，不能修改原有集合里面的内容（不能通过原有集合的引用来修改里面的数据。 ）
    }

}

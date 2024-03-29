package com.cskaoyan._19collection._05example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 怎么删除里面 所有的 zs
 * 1.迭代器。
 * 2.remove()
 * 3.removeAll()
 * 4.换一个新的集合。不是zs加进去。
 *
 * @author Common-zhou
 * @since 2024-03-29 17:31
 */
public class Demo5 {
    @Test
    public void test1() {
        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zs");
        collection.add("zl");

        // 1.迭代器。

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if ("zs".equals(element)) {
                iterator.remove();
            }
        }

        System.out.println(collection);
    }


    @Test
    public void test2() {
        // 2.remove()

        Collection<String> collection = new ArrayList<>();

        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("zs");
        collection.add("zl");

        // 如果本次操作，影响了Collection里面的内容，就是true；否则就是false。
        // collection.remove()

        collection.remove("zs");

        while (true) {
            boolean removed = collection.remove("zs");

            if (!removed) {
                break;
            }
        }
        System.out.println(collection);

    }

}

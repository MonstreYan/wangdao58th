package com.cskaoyan._19collection._02collection._05example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Common-zhou
 * @since 2024-03-30 10:35
 */
public class Demo7Reivew {
    @Test
    public void test1() {
        // iterator 迭代器。 也称光标。是一个接口。

        Collection<String> collection = new ArrayList<>();

        collection.add("蜜雪冰城");
        collection.add("七分甜");
        collection.add("书亦烧仙草");
        collection.add("霸王茶姬");
        // 迭代器： 接口。
        Iterator<String> iterator = collection.iterator();

        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        System.out.println("iterator.next() = " + iterator.next()); // 蜜雪冰城
        //     蜜雪冰城   七分甜     书亦烧仙草    霸王茶姬
        //                                             |

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.next() = " + iterator.next()); // 七分甜

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.next() = " + iterator.next()); // 书亦烧仙草

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.next() = " + iterator.next()); // 霸王茶姬

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // false
        // System.out.println("iterator.next() = " + iterator.next());

    }

    @Test
    public void test2() {
        Collection<String> collection = new ArrayList<>();

        collection.add("蜜雪冰城");
        collection.add("七分甜");
        collection.add("书亦烧仙草");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {
            //
            String element = iterator.next();
            System.out.println(element);
        }

        // itit
        // while (iterator.hasNext()) {
        //     String next = iterator.next();
        //
        // }
    }

    @Test
    public void testConcurrent() {
        // 在使用迭代器的过程中，不能通过原有集合。去对数据进行增删改。

        Collection<String> collection = new ArrayList<>();

        collection.add("蜜雪冰城");
        collection.add("七分甜");
        collection.add("书亦烧仙草");
        collection.add("霸王茶姬");
        collection.add("霸王茶姬");

        // 要么在迭代器生成之前操作 ===================================================

        Iterator<String> iterator = collection.iterator();

        // 在使用迭代器的过程中，不能操作原有集合。
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // collection.add("zss");
        }

        // 要么在迭代器适用完成之后 ===================================================
    }
}

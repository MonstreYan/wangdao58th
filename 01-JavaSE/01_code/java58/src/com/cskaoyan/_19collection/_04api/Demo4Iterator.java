package com.cskaoyan._19collection._04api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Common-zhou
 * @since 2024-03-29 15:08
 */
public class Demo4Iterator {
    @Test
    public void test1() {
        // 迭代器。是一种设计模式。是用来帮助开发人员访问容器中的数据的。 而无须关心容器底层是怎么实现的。
        // 数组： int index
        // 链表： Node node
    }


    @Test
    public void test2() {
        // 迭代器： 是个接口。
        Collection<String> collection = new ArrayList<>();
        collection.add("蜜雪冰城");
        collection.add("茶颜悦色");
        collection.add("七分甜");

        Iterator<String> iterator = collection.iterator();

        // hasNext  : 判断下一个是否有数据。
        // next: 将指针往后移，并且返回刚刚经过的元素。
        //    蜜雪冰城    茶颜悦色    七分甜
        //                                |

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.next() = " + iterator.next()); // 蜜雪冰城

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // true
        System.out.println("iterator.next() = " + iterator.next()); // 茶颜悦色

        System.out.println("iterator.next() = " + iterator.next()); // 七分甜

        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // false

        // 如果后面没数据了，调用next，会报错

        System.out.println("iterator.next() = " + iterator.next());
    }


    @Test
    public void test3() {
        // 刚刚是手动遍历。

        Collection<String> collection = new ArrayList<>();
        collection.add("蜜雪冰城");
        collection.add("茶颜悦色");
        collection.add("七分甜1");
        collection.add("七分甜2");
        collection.add("七分甜3");
        collection.add("七分甜4");
        collection.add("七分甜5");
        collection.add("七分甜6");

        Iterator<String> iterator = collection.iterator();
        //    蜜雪冰城   茶颜悦色   七分甜1    七分甜2    七分甜3
        //  |

        while (iterator.hasNext()) {
            // 如果能hasNext。 说明有数据。
            String next = iterator.next();
            System.out.println(next);
        }
    }


    @Test
    public void test4() {
        // remove。 删除。删除刚刚遍历过的元素
        // 迭代器，本身保不保存集合中的数据。 不保存集合中的数据。
        // 删除的是集合中的数据。
        Collection<String> collection = new ArrayList<>();
        collection.add("蜜雪冰城");
        collection.add("茶颜悦色");
        collection.add("七分甜1");
        System.out.println(collection);

        Iterator<String> iterator = collection.iterator();

        // 不能没遍历，就直接开始删除。
        // iterator.remove();

        //       茶颜悦色    七分甜1
        //               |

        String next = iterator.next();
        System.out.println("next = " + next);

        iterator.remove();

        String next1 = iterator.next();
        System.out.println(next1);
        iterator.remove();

        System.out.println(collection);


    }


    @Test
    public void test5() {
        // remove。 删除。删除刚刚遍历过的元素
        Collection<String> collection = new ArrayList<>();
        collection.add("蜜雪冰城");
        collection.add("茶颜悦色");
        collection.add("七分甜1");

        // 刚刚的刚刚

        Iterator<String> iterator = collection.iterator();

        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        iterator.remove();
        iterator.remove();

        // remove. 只能遍历一次，删除一次。

        System.out.println(collection);
    }


    @Test
    public void test6() {
        // 为什么要把这东西设计成接口。
        // 接口有什么好处？
        // Collection<String> collection = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        collection.add("蜜雪冰城");
        collection.add("茶颜悦色");
        collection.add("七分甜1");

        // 接口： 定义规范。
        // 只定义方法，不同的子实现，可以按照自身的特点来实现。
        Iterator<String> iterator = collection.iterator();

        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        // ArrayList: 数组
        // LinkedList: 数组
    }

    @Test
    public void test7() {
        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");
        System.out.println("collection.size() = " + collection.size());

        // hasNext()
        // next();
        // 对于这两个方法，在数组（ArrayList）中的实现，和在链表(LinkedList)中的实现，是否可能一致。
        // 接口： 就是起到规范的作用。
    }


    @Test
    public void test8Concurrent() {
        // 并发修改异常问题。
        Collection<String> collection = new ArrayList<>();
        collection.add("zs");
        collection.add("ls");
        collection.add("zs");
        collection.add("wu");
        collection.add("zs");


        // 迭代器的主要作用： 遍历。
        // 如果在使用迭代器的过程中，原本的元素变了。

        // 如果现在，在用迭代器进行统计个数。 使用迭代器的过程中，原本集合的数据变了。这时候数据不对。
        // 并发修改异常问题。

        // ===================================迭代器生成之前

        Iterator<String> iterator = collection.iterator();
        int countZs = 0;
        while (iterator.hasNext()) {
            String next = iterator.next();

            if ("zs".equals(next)) {
                countZs++;
            }

            // collection.remove("zs");
        }

        // ===================================迭代器使用完成之后。

        //ConcurrentModificationException
        System.out.println(countZs);

        // 出现的原因： 就是在使用迭代器迭代的过程中，又通过原有集合去操作了原本的数据，这时候，JDK认为数据不对，直接报错
        // 解决： 要么在生成迭代器之前对原本数据进行操作。要么在使用完成迭代器之后对原本集合进行操作。


    }

}

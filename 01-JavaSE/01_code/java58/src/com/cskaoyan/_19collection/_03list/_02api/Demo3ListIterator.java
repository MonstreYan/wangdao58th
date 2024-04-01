package com.cskaoyan._19collection._03list._02api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator
 *
 * @author Common-zhou
 * @since 2024-04-01 14:44
 */
public class Demo3ListIterator {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            System.out.println("listIterator.next() = " + listIterator.next());
        }
    }

    @Test
    public void test2() {
        // ListIterator就是一个接口。之前的Iterator，只能从前往后移。现在的ListIterator，可以前后移动。

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        //    zs    ls   wu
        //  |


        ListIterator<String> listIterator = list.listIterator();

        System.out.println("listIterator.hasNext() = " + listIterator.hasNext()); // true
        System.out.println("listIterator.hasPrevious() = " + listIterator.hasPrevious());  // false

        System.out.println("listIterator.next() = " + listIterator.next());  //zs

        System.out.println("listIterator.hasNext() = " + listIterator.hasNext()); // true
        System.out.println("listIterator.hasPrevious() = " + listIterator.hasPrevious());  // true

        System.out.println("listIterator.next() = " + listIterator.next());  //ls
        System.out.println("listIterator.next() = " + listIterator.next());  //wu

        System.out.println("listIterator.hasNext() = " + listIterator.hasNext()); // false
        System.out.println("listIterator.hasPrevious() = " + listIterator.hasPrevious());  // true

        //
        System.out.println("listIterator.previous() = " + listIterator.previous());
        System.out.println("listIterator.previous() = " + listIterator.previous());
        System.out.println("listIterator.previous() = " + listIterator.previous());

    }


    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        //    zs    ls   wu
        //        |

        ListIterator<String> listIterator = list.listIterator();

        System.out.println("listIterator.nextIndex() = " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() = " + listIterator.previousIndex());
        listIterator.next();
        System.out.println("listIterator.nextIndex() = " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() = " + listIterator.previousIndex());

    }

    @Test
    public void test4() {


        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        //    zs  ls  wu
        //  |

        ListIterator<String> listIterator = list.listIterator();

        System.out.println("listIterator.next() = " + listIterator.next());

        System.out.println("listIterator.previous() = " + listIterator.previous());
        listIterator.remove();

        System.out.println(list);

    }

    @Test
    public void test5() {
        //void add(E e) : 添加一个数据到当前遍历位置,并且把指针往后挪一下
        //void set(E e) : 修改刚刚遍历过的元素位置

        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");

        ListIterator<String> listIterator = list.listIterator();

        listIterator.next();
        listIterator.add("11122");
        listIterator.add("99988");
        //    zs  111222  ls       wu
        //              |
        System.out.println(list);


        List<String> list1 = new ArrayList<>();
        list1.add("zs");
        list1.add("ls");
        list1.add("wu");

        //    zs   ls    wu
        //            |

        ListIterator<String> listIterator1 = list1.listIterator();

        String next = listIterator1.next();

        listIterator1.next();

        listIterator1.set("987987");
        listIterator1.set("9856542155");
        System.out.println(list1);


    }


    @Test
    public void test6() {
        // - 有参构造，返回的迭代器对象，调用next返回的是指定下标的元素。所以传入的index应该在什么范围？[0,length]

        List<String> list1 = new ArrayList<>();
        list1.add("zs");
        list1.add("ls");
        list1.add("wu");

        ListIterator<String> listIterator = list1.listIterator(1);

        //   zs    ls    wu
        // |     |
        // 0

        System.out.println("listIterator.next() = " + listIterator.next());
    }

    @Test
    public void test7() {
        List<String> list1 = new ArrayList<>();
        list1.add("zs");
        list1.add("ls");
        list1.add("wu");


        ListIterator<String> listIterator = list1.listIterator();

        listIterator.next();

        //   zs   666   ls   wu
        //      |

        listIterator.add("666");
        listIterator.previous();
        listIterator.set("9999999");


        System.out.println(list1);

    }
}

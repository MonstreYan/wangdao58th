package com.cskaoyan._19collection._03list._03subclass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Common-zhou
 * @since 2024-04-01 16:00
 */
public class Demo1ArrayList {

    @Test
    public void test1() {
        //    ArrayList() 构造一个初始容量为 10 的空列表。
        //    ArrayList(Collection<? extends E> c)：构造一个包含指定 collection 的元素的列表，
        //    这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
        //    ArrayList(int initialCapacity)：构造一个具有指定初始容量的空列表。

        List<String> list = new ArrayList<>();

        List<String> list2 = new ArrayList<>();
        list2.add("zs");
        list2.add("ls");
        list2.add("wu");
        list2.add("zl");

        // 创建一个新的ArrayList。里面有collection里面有的数据
        List<String> list3 = new ArrayList<>(list2);

        System.out.println(list3);

        ArrayList<String> strings = new ArrayList<>(10);
    }

    @Test
    public void test2() {
        // 生成List的一种简单写法。
        // Arrays.asList()
        List<String> list = Arrays.asList("zs", "ls", "wu", "zl", "aaa", "bbb");

        System.out.println(list);

        // 2.简单的写法，需要注意的一个问题。 这玩意，生成了一个List，但是这个List不能添加、删除数据。
        // UnsupportedOperationException
        // list.add("987987");
        // list.remove(1);

        // 用Arrays.asList生成的List，不能添加，不能删除。 只能用它来遍历。
    }

    @Test
    public void test3() {
        // 如果今后想偷懒，既想生成数据，又想生成了之后的List能添加，删除。
        List<String> list = Arrays.asList("zs", "ls", "wu", "zl", "aaa", "bbb");

        List<String> list2 = new ArrayList<>(list);
        list2.add("9898989");

        // 简化写法。
        List<String> list3 = new ArrayList<>(Arrays.asList("zs", "ls", "wu", "zl", "aaa", "bbb"));

    }


    @Test
    public void test4() {
        //    void ensureCapacity(int minCapacity)
        //    如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。

        // 这是ArrayList的特有API。在List接口中没有。
        ArrayList<String> list = new ArrayList<>();

        list.add("zs");

        // 传入一个数，如果这个数比当前容量小，不管它；如果，传入的数，比较大，数组进行扩容。
        // 明确知道一些容量，比如100w。 这时候可以直接调用这种方法，然后避免不断不断的进行扩容。
        list.ensureCapacity(100);

    }

    @Test
    public void test5() {
        //    void trimToSize( )
        //    将此 ArrayList 实例的容量调整为列表的当前大小。
        ArrayList<String> list = new ArrayList<>();

        list.add("zs");
        list.add("ls");

        list.trimToSize();
    }

}

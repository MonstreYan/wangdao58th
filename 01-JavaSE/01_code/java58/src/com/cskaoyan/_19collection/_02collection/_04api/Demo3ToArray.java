package com.cskaoyan._19collection._02collection._04api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Common-zhou
 * @since 2024-03-29 11:43
 */
public class Demo3ToArray {
    @Test
    public void test1() {
    }

    @Test
    public void test2() {
        //    Object[] toArray(): 将collection转成一个数组，方便遍历
        // 转成了一个Object类型的数组。 但是现在需要做强转才ok。

        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");
        collection.add("二营长");
        collection.add("秀芹");

        Object[] array = collection.toArray();
        for (Object o : array) {
            // 里面，应该是 String
            // System.out.println(o.getClass());
            // System.out.println("o = " + o);

            String element = (String) o;
            // System.out.println("element = " + element);

            // 转成子类之后，可以调用子类特有的方法。
            //
            if (element.length() > 2) {
                System.out.println("element = " + element);
            }
        }
    }

    @Test
    public void test3() {
        //    <T> T[] toArray(T[] a)：类似，只是传入了一个数组
        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");
        collection.add("二营长");
        collection.add("秀芹");
        collection.add("意大利炮");


        String[] array = new String[5];
        String[] returnArray = collection.toArray(array);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(returnArray));
        // 这个方法，传了个数组进去。 数组在里面是怎么用的。
        // 如果传入的长度够， 这时候会用你传入的数组。
        // 如果长度不够，这时候，会用你的类型
        System.out.println(array == returnArray);

        // 底层是怎么实现的？
        // 下午时候看源码。
    }

    @Test
    public void test4() {
        // 传入的数组类型，一定要一致。
        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");
        collection.add("二营长");
        collection.add("秀芹");
        collection.add("意大利炮");

        Integer[] integers = new Integer[10];

        // element type mismatch: can not cast one of the elements of java.lang.Object[] to
        // the type of the destination array, java.lang.Integer
        // Integer[] array = collection.toArray(integers);
        // System.out.println(Arrays.toString(array));

        // 调用toArray的有参的时候，一定要注意一下类型。
        // 无参方法，和有参方法。 toArray 的。 是有参的用的多一点。
    }


    @Test
    public void testReadCode() {
        // toArray的无参方法，内部是怎么实现的。
        // ArrayList为例。
        Collection<String> collection = new ArrayList<>();

        // 接口里面没有toArray的实现。
        // 看怎么实现的，得看实现类里面的。
        // 编译看左边，运行看右边。 编译的时候能点出来的就是接口里面有的方法，运行的时候，实际调用的方法
        // 就是看右边实际的类型。
        collection.toArray();

        //     public Object[] toArray() {
        //         return Arrays.copyOf(elementData, size);
        //     }
        // 无参的toArray方法，就是将elementData复制了一份 。长度是size。

        // 看源码的方式：
        // 方式1： 直接进入这个类。然后 ctrl + f12；直接输入方法名
        // 方式2： 先进入接口的声明中。（ctrl+鼠标左键点击方法）； 点旁边的符号，搜索。

    }

    @Test
    public void testReadCode2() {
        // toArray的有参构造方法，是怎么写的。
        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");

        // String[] array = new String[]{"1", "2", "3"};
        // String[] array = new String[]{"1", "2", "3", "4", "5"};
        String[] array = new String[]{"1", "2"};
        String[] returnArray = collection.toArray(array);

        System.out.println(array == returnArray);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(returnArray));
    }

    @Test
    public void test5() {
        // 今后是怎么使用这个toArray的有参。
        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");


        String[] strings = new String[collection.size()];
        collection.toArray(strings);

        //  推荐的写法。 =========================
        String[] array = collection.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void test6() {
        // toArray的作用： 遍历。
        Collection<String> collection = new ArrayList<>();
        collection.add("李云龙");
        collection.add("孔捷");
        collection.add("楚云飞");

        // 对于遍历来说。 toArray。
        // 复制。
        // 遍历这个操作非常普遍。
        // 每一次遍历，都copy一份，需要耗费哪些时间？
        // 1.数组开辟需要时间。
        // 2.copy数据需要时间
        // 3.GC也需要时间。

        // 有没有什么办法，能够简化这个遍历。
        // 之前用数组，我们是怎么遍历的？  index
        // 如果是链表，怎么遍历？  用一个指针。
        // JDK里面，能不能把这个操作统一一下。 用迭代器。
    }
}

package com.cskaoyan._19collection._04api;

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
}

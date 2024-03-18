package com.cskaoyan._09string._05stringbuilder;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 17:24
 */
public class Demo2 {

    @Test
    public void testConstructor() {
        // public StringBuffer() // 默认容量是16
        // public StringBuffer(int capacity)// 容量是capacity
        // public StringBuffer(String str)// str的长度+16

        // 创建了长度为16的 char[] 数组用于存储数据
        StringBuffer stringBuffer = new StringBuffer();

        StringBuilder stringBuilder = new StringBuilder(10);

        new StringBuilder("hello");
    }

    @Test
    public void test2() {
        // 获取功能
        // public int capacity() 返回当前容量,数组的长度,理论值
        // public int length() 返回长度(字符的个数),实际值

        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("stringBuilder.capacity() = " + stringBuilder.capacity());
        System.out.println("stringBuilder.length() = " + stringBuilder.length());


    }


    @Test
    public void test3() {
        // 添加功能
        // public StringBuffer append(String s) 将指定的字符串(其他类型有重载方法)追加到此字符序列的尾部
        //         在指定位置把任意类型的数据插入到字符串缓冲区里面

        String s = "abc";
        s += "0";
        s += "1";
        s += "2";
        s += "3";
        // String操作，都是创建了新的，然后拼接。
        // 可变长字符串，都是在原本字符串上操作。


        StringBuilder stringBuilder = new StringBuilder();

        // append 是在原有的字符串操作，还是创建了个新的。
        StringBuilder builder = stringBuilder.append("123456");

        System.out.println(builder);
        System.out.println(stringBuilder == builder);
    }

    @Test
    public void test4() {
        StringBuilder stringBuilder = new StringBuilder();

        // append的返回值，就是当前对象。 这个可以实现链式编程。
        // append方法，就是往之前的字符数组上，添加内容。操作的对象是原本的对象。 没有创建新的对象。
        stringBuilder.append("hello").append("world").append("123").append("Java");
        System.out.println(stringBuilder);
    }

    @Test
    public void test5() {
        // public StringBuffer insert(int offset,String str)

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello").append("Java").append("Java58");

        stringBuilder.insert(2, "景天");

        System.out.println(stringBuilder);
    }


    @Test
    public void test6() {
        // 下方的Api，只要注意。 操作的数据，都是在原本的数据上面。

        // 删除功能
        // public StringBuffer deleteCharAt(int index)：删除指定位置的字符
        // public StringBuffer delete(int start,int end)：删除从指定位置开始指定位置结束的内容
        //         替换功能

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("茶颜悦色").append("霸王茶姬").append("蜜雪冰城").append("书亦烧仙草");

        stringBuilder.deleteCharAt(1);
        System.out.println(stringBuilder);

        // 茶悦色霸王茶姬蜜雪冰城书亦烧仙草
        // 0 12 3 45
        stringBuilder.delete(1, 4);
        System.out.println(stringBuilder);
        // [1,4) 包左不包右。

        // API都是看方法的名字 + 方法的参数。 ==》 组合起来猜测代码的功能。

    }

    @Test
    public void test7() {
        // 使用给定String中的字符替换词序列的子字符串中的字符
        // public StringBuffer replace(int start,int end,String str)

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("茶颜悦色").append("霸王茶姬").append("蜜雪冰城").append("书亦烧仙草");

        System.out.println(stringBuilder);

        // 茶颜悦色霸王茶姬蜜雪冰城书亦烧仙草
        // 01 23 4 5

        stringBuilder.replace(0, 5, "喜茶");

        System.out.println(stringBuilder);

    }

    @Test
    public void testN() {
        // 反转功能
        // public StringBuffer reverse()：将此字符序列用其反转形式取代，返回对象本身
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("茶颜悦色").append("霸王茶姬").append("蜜雪冰城").append("书亦烧仙草");

        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }


    @Test
    public void test8() {

        // String   StringBuilder要相互转换。 这些方式要回。
        // String ---> StringBuilder StringBuffer 就是通过构造方法的形式。
        String abc = "abc";
        StringBuilder stringBuilder = new StringBuilder(abc);
        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.reverse();

        // StringBuilder  ---》 String
        String string = stringBuilder.toString();
        System.out.println(string);
    }

}

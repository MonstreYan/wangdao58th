package com.cskaoyan._19collection._05deque;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ArrayDeque的构造方法。
 *
 * @author Common-zhou
 * @since 2024-04-02 11:06
 */
public class Demo3ArrayDequeConstructor {
    @Test
    public void test1() {
        // ArrayDeque()
        // 构造一个初始容量能够容纳 16 个元素的空数组双端队列。  扩容机制 *2 （JDK8）
        // 构造一个初始容量能够容纳 17 个元素的空数组双端队列。   （JDK17）

        //     public ArrayDeque() {
        //         elements = new Object[16];
        //     }
        ArrayDeque<String> strings = new ArrayDeque<>();


        // 16   32
        // 4    5   6   7   8   9
        // 长度一直是2的幂次方。
    }

    @Test
    public void test2() {
        // 如果b是2的幂次方,(2 4 8 )。 a%b = a&(b-1)

        // 先以10进制为例。
        // 1008611 % 10 = (1008600 + 10 + 1) % 10 = 1

        // 53 % 16
        // 0011 0101 % 0001 0000
        // (0010 0000 + 0001 0000 + 0000 0101 ) %
        //  如果能自己推出来，更好； 推不出来，先记忆一下。

    }

    @Test
    public void test3() {
        ArrayDeque<String> strings = new ArrayDeque<>();

        strings.offer("zs");


        ArrayList<String> strings1 = new ArrayList<>();

        strings.add("zs");
        strings.add("ls");
        strings.add("wu");
        strings.add("zl");

        ArrayList<String> strings2 = new ArrayList<>(strings);

    }

    @Test
    public void test4(){
        // ArrayDeque(int numElements)
        // 构造一个初始容量能够容纳指定数量的元素的空数组双端队列。

        // 底层的元素个数。
        // 无参的时候，长度是多少  16； 扩容按两倍扩
        // 如果，我们传入了一个不是2的幂次方，它不可能就直接用你这个数。
        // 一定会进行操作。
        // 在底层，并没有直接使用你传入的值。 而是 进行了一个计算。

        ArrayDeque<String> strings = new ArrayDeque<>(13);

        strings.add("zs");

    }
}

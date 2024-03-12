package com.cskaoyan._05oop2;

/**
 * final修饰成员/静态成员变量，表示一个常量，必须明确地赋值。
 * 自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
 * 再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
 * 然后：
 * 1，请用三种不同的方式，分别为成员变量a，b，c赋值
 * 2，请用两种不同的方式，分别为静态成员变量staticA和staticB赋值
 * <p>
 * <p>
 * 现在，要给final修饰的成员变量赋值。   ====》 有哪几种方式，可以给成员变量赋值。
 *
 * tips: 对于构造方法赋值。 一定要保证每一个构造方法都能对final变量赋值。 比如都能给c赋值。
 *
 * 很多时候，要听懂面试官的问题。
 * ArrayList(数组) 和  LinkedList(链表)。你的认识。  ===>
 *
 *
 * @author Common-zhou
 * @since 2024-03-12 09:31
 */
public class Homework1 {


    final int a = 10;
    final int b;

    {
        b = 20;
    }

    final int c;


    public Homework1(int b, int c) {
        // Variable 'b' might already have been assigned to
        // final修饰，只能赋值一次。
        // this.b = b;
        this.c = c;
    }
}

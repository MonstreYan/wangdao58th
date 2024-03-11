package com.cskaoyan._05oop2._02extends._10hiddern;

/**
 * 在上面章节中，我们已经知道，父子类的成员是允许同名的。那么如果父子类属性同名了，那么不使用super区分，
 * 直接访问的效果是什么样的呢？
 * <p>
 * 现在我们直接创建子类对象，使用子类引用接收。会发现访问的结果是子类中属性的取值，
 * 那么父类中的那个成员变量去哪了呢？首先它肯定是存在的，这一点随便写一个父类成员变量的Getter方法就可以验证了。
 * 这说明使用 "对象名点"访问成员变量 这个语法，可能存在一些特殊的机制，接下来我们就来探讨这种机制。
 *
 * @author Common-zhou
 * @since 2024-03-11 10:16
 */
public class Demo1 {

    public static void main(String[] args) {
        // 父子类的成员变量，是允许同名的。  现在访问出来的name。是哪个

        Son1 son1 = new Son1();
        String name = son1.name;
        // son
        System.out.println(name);

        Father1 father1 = new Father1();
        System.out.println("father1.name = " + father1.name);

        // 父类引用，指向子类对象。
        Father1 father2 = new Son1();

        System.out.println("father2.name = " + father2.name); // father

        // 在这块，是有一些特殊的语法的。

    }
}


class Father1 {
    String name = "father";
}


class Son1 extends Father1 {
    String name = "son";
}

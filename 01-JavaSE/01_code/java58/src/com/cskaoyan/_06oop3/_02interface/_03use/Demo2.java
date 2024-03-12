package com.cskaoyan._06oop3._02interface._03use;

/**
 * **成员特点**
 * - 能不能定义属性?(成员变量,静态成员变量,全局常量)
 * - 可以定义,但是接口中的属性默认都是"public static final"修饰的公共的全局常量
 * - 这些隐含的修饰符不要写出来, 接口能够定义的所有结构的访问权限都是public, 而且public是隐含的修改不了
 * - 接口中没有静态代码块,接口中的全局常量,必须显式赋值
 * - 接口表示对功能的扩展,所以接口往往只有对行为的抽象(接口往往只有方法),接口是非常少见定义属性的,
 * 只有当接口的所有实现类,都需要一个共同的全局常量时才考虑在接口中定义属性.
 * <p>
 * ==============================在接口中，尽量只定义方法，不要定义属性。
 * - 能不能定义方法/行为?
 * - 可以定义方法,但是接口中的方法默认都是"public abstract"修饰的公共的抽象方法
 * - 实际上,在Java8之前,接口中没有任何实现方法,接口中只能定义抽象方法
 * - 特别强调: 实际开发中,99%的情况下,接口就只有光秃秃的抽象方法定义,没有其他任何内容
 *
 *
 * 接口是没有构造器的,接口自己用不到构造器
 *  构造方法的作用是干什么？  对属性进行赋值的。
 *  抽象类中，有没有属性？
 *  接口中，没有属性。
 *
 *
 * @author Common-zhou
 * @since 2024-03-12 11:30
 */
public class Demo2 {
    public static void main(String[] args) {
        int age = Fly2.age;
        // Fly2.age = 21;
    }
}

interface Fly2 {
    int age = 10;
    // Modifier 'private' not allowed here
    // 在接口中可以定义属性，但是属性自带一些修饰符。 直接就是常量。
    // public static final
    // 一般情况下，不在接口中定义这些东西。
    int age2 = 20;

    // static {
    //     System.out.println("1111");
    // }

    void play2();


}


interface Fly21 {
    // 在实际的工作过程中，接口中只有方法的定义。 没有属性，也没有方法的实现
    void fly1();

    int fly2(int age);

    String fly3();


}

package com.cskaoyan._06oop3._06lambda;

/**
 * lambda的语法：
 * (形参列表) -> {
 * // 方法体
 * }
 *
 * @author Common-zhou
 * @since 2024-03-14 14:52
 */
public class Demo3 {
    public static void main(String[] args) {
        // lambda表达式的基本语法。

        // 这就是lambda表达式
        Play3 play3 = () -> {
            System.out.println("play3 method");
        };

        Play3 play31 = () -> {
            System.out.println("play3 inner");
        };

        // lambda表达式。就是用来替代匿名内部类对象。
        // 但是它替代的，只能是功能接口。


        // 如果光写这个结构，肯定会报错。
        // 因为Java是一个强类型语言，必须要告诉它类型。 在这个结构中，编译器，不知道这个几个欧的类型。
        // 所以，必须要帮助编译器推断结构的类型。
        // ()->{
        //     System.out.println("hello world");
        // };


        // 1.直接用父接口引用接收。由于Lambda表达式表示的子类对象并没有自己独有的成员，所以直接用父类引用接收完全不会有任何问题。
        Play3 play32 = () -> {
            System.out.println("hello world");
        };

        // 2.((父接口的名字)Lambda表达式).方法名(实参)
        ((Play3) () -> {
            System.out.println("hello world");
        }).play();

        // 3.借助方法完成类型推断。
        // 借助返回值
        // 借助形参
    }

    public Play3 test1() {

        test2(() -> {
            System.out.println("hhhhhhh");
        });


        // 可以借助方法的返回值。 来帮助编译器理解这个lambda的结构。。
        return () -> {
            System.out.println("hello world");
        };
    }

    public void test2(Play3 play3) {

    }

}

@FunctionalInterface
interface Play3 {
    void play();
}

package com.cskaoyan._06oop3._06lambda;

/**
 * Lambda表达式： 是一个匿名内部类对象。
 * 主要的目的，就是为了替代它。
 * <p>
 * 是否能替代所有的匿名内部类对象？  只能替代有一个抽象方法的接口。
 *
 * @author Common-zhou
 * @since 2024-03-14 15:07
 */
public class Demo4 {
    public static void main(String[] args) {

        // lambda表达式的语法
        // (形参列表) -> {方法体}

        // 为了替代匿名内部类对象的。
        new Play4() {
            @Override
            public void play() {

            }
        };

        // 编译器，不认识这个结构。  ==》 帮助编译器认识这个结构。
        // 1.直接使用父接口引用来接收。
        Play4 play4 = () -> {
            System.out.println("hello lambda");
        };

        // 2.直接在前面加上一个类似强转的语法。
        ((Play4) () -> {
            System.out.println("hello lambda222222");
        }).play();

        // 3.借助方法的形参和返回值。帮助编译器认识。
    }


    public Play4 test1() {
        // 方法的返回值。 是Play4接口。

        test2(() -> {
            System.out.println("hello lambda222222");
        });


        // 编译器，就能猜出来。这是lambda的。 是Play4的一个子实现。
        return () -> {
            System.out.println("hello lambda222222");
        };
    }

    public void test2(Play4 play4) {
        play4.play();
    }
}


//这个是一个接口
interface Play4 {
    void play();
}


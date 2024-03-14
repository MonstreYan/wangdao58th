package com.cskaoyan._06oop3._06lambda;

import org.junit.Test;

/**
 * ========================晚上重点看一下，
 * @author Common-zhou
 * @since 2024-03-14 15:18
 */
public class Demo5 {

    @Test
    public void test1() {
        // 写这个接口的一个lambda表达式。 怎么写
        // (形参)->{方法体}

        INoReturnNoParam iNoReturnNoParam = () -> {
            System.out.println("INoReturnNoParam print");
        };

        // 这个叫啥。 父接口指向子类对象。 ==》 多态。
        iNoReturnNoParam.test();


        // lambda就是一个匿名内部类对象。
        // INoReturnNoParam iNoReturnNoParam1 = new INoReturnNoParam(){
        //     @Override
        //     public void test() {
        //
        //     }
        // };
    }

    @Test
    public void test2() {
        // Incompatible parameter types in lambda expression: wrong number of parameters:
        // expected 1 but found 0
        INoReturnOneParam iNoReturnOneParam = (int a) -> {
            System.out.println(a + 1 + "=====" + "INoReturnOneParam");
        };

        iNoReturnOneParam.test(19);

        // 接口中的方法，如果有参数，那么在lambda这里，一定要写参数。

        // 1.改进1.类型可以不写，可以根据接口中方法来推断。
        INoReturnOneParam iNoReturnOneParam1 = (a) -> {
            System.out.println(a + 2 + "======>" + "INoReturnOneParam");
        };

        iNoReturnOneParam1.test(97);

        // 2.括号可以不写。但是在无参的时候。必须要写这个括号。
        INoReturnOneParam iNoReturnOneParam2 = a -> {
            System.out.println(a + 2 + "======>" + "INoReturnOneParam");
        };
        iNoReturnOneParam2.test(34);


        // 没有参数的时候，括号一定要写。
        // INoReturnNoParam iNoReturnNoParam =  -> {
        //     System.out.println("INoReturnNoParam print");
        // };


    }


    @Test
    public void test3() {
        // 没有返回值，有两个参数的功能接口。
        // 编译器根据左边，知道这是一个 INoReturnTwoParam 接口。
        // ()->{}  ===>   知道这是lambda表达式。
        // Incompatible parameter types in lambda expression:
        // wrong number of parameters: expected 2 but found 0
        INoReturnTwoParam iNoReturnTwoParam = (num1, num2) -> {
            // num1 和 num2分别代表谁？
            // 只根据顺序来。 名字没有影响。名字只影响方法内部（局部变量）
            System.out.println("num1 = " + num1 + ".num2 = " + num2 + "=================>INoReturnTwoParam");
        };

        iNoReturnTwoParam.test(10, 20);
        iNoReturnTwoParam.test(20, 10);

        // 参数类型，可写，可不写。 但是要写都写。要不写都不写。
        INoReturnTwoParam iNoReturnTwoParam1 = (int num1, int num2) -> {
            System.out.println("num1 = " + num1 + ".num2 = " + num2 + "=================>INoReturnTwoParam");
        };


    }

    @Test
    public void test4() {
        IHasReturnNoParam iHasReturnNoParam = () -> {
            System.out.println("IHasReturnNoParam");
            // Missing return statement
            return 1;
        };

        int test = iHasReturnNoParam.test();
        System.out.println(test);
    }

    @Test
    public void test5() {
        IHasReturnOneParam iHasReturnOneParam = (num) -> {
            System.out.println("iHasReturnOneParam" + num);
            return num + 5;
        };


        int result = iHasReturnOneParam.test(10);
        System.out.println(result);
    }

    @Test
    public void test6() {
        IHasReturnTwoParam iHasReturnTwoParam = (num1, num2) -> {
            System.out.println("iHasReturnTwoParam");
            return num1 + num2 + 2;
        };

        int num = iHasReturnTwoParam.test(10, 20);
        System.out.println(num);
    }


    @Test
    public void test7() {
        // 1. 如果方法重写的方法体只有一条语句的话，那么可以省略大括号。（类似于if/for省略大括号）
        // 2. 特殊的，如果只有一条语句且这条语句是返回值语句，那么大括号和return可以一起省略。

        IHasReturnTwoParam iHasReturnTwoParam = (num1, num2) -> num1 + num2;

        INoReturnTwoParam iNoReturnTwoParam = (num1, num2) -> System.out.println(num1 + num2);
    }


    @Test
    public void test8() {
        // lambda表达式中，东西非常多。 需不需要挨个记？
        // 不需要。
        // lambda表达式的最主要目的： 简化代码。
        // 简化代码，一定是建立在一个前提下的。===>你要认识这个代码

        // 一些小妙招。
        // 比如，我现在想写。  IHasReturnTwoParam的表达式。 但是忘了lambda怎么写。
        // 1)先写匿名内部类对象。
        // 2)用idea帮你替换.  点到灰色的地方。 alt+enter  replace with lambda
        IHasReturnTwoParam iHasReturnTwoParam = (a, b) -> {
            System.out.println(a + b + "===>IHasReturnTwoParam");
            return a + b;
        };
        iHasReturnTwoParam.test(10, 20);

        // 善于运用idea里面 帮忙提供的一些改写方式。
        IHasReturnTwoParam iHasReturnTwoParam1 = (a, b) -> a + b;


        // 之前JDK底层，写了很多的方法。 对于这些方法可以直接使用。 使用的规则就是这种，这个就叫做方法的引用
        IHasReturnTwoParam iHasReturnTwoParam2 = Integer::sum;

        // 方法的引用。就是对于一些方法，实现起来比较复杂。JDK提供了相关的方法， 这时候可以直接引用JDK的实现，不用自己写。
        // 我这有俩参数， 你这也有俩参数。 JDK， 要不你直接用我的。
        IHasReturnTwoParam iHasReturnTwoParam3 = (a, b) -> Integer.sum(a, b);
        IHasReturnTwoParam iHasReturnTwoParam4 = Integer::sum;


    }

}


@FunctionalInterface
interface INoReturnNoParam {
    void test();
}


//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}


//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}


//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}


//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int test(int a);
}


//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}

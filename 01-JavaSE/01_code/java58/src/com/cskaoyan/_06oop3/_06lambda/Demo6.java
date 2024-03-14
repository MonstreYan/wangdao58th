package com.cskaoyan._06oop3._06lambda;

import org.junit.Test;

/**
 * Dmeo6仅做了解。
 * 方法引用，建议大家了解一下。 平常的时候，不建议这样写。
 *
 * @author Common-zhou
 * @since 2024-03-14 16:15
 */
public class Demo6 {
    @Test
    public void test1() {
        // 类名引用静态方法(x, y, ...) -> 类名.静态方法名(x, y, ...)类名::静态方法名功能接口中被实现方法的全部参数传给该类静态方法作为参数

        // 类名引用静态方法
        // Integer.sum();

        IHasReturnTwoParam iHasReturnTwoParam1 = (a, b) -> a + b;


        IHasReturnTwoParam iHasReturnTwoParam11 = new IHasReturnTwoParam() {
            @Override
            public int test(int a, int b) {
                return a + b;
            }
        };

        // 这个就是等价的。
        IHasReturnTwoParam iHasReturnTwoParam2 = (a, b) -> Integer.sum(a, b);
        IHasReturnTwoParam iHasReturnTwoParam3 = Integer::sum;
        // 不建议给它改成引用。因为不好看。
        IHasReturnTwoParam iHasReturnTwoParam4 = (a, b) -> Integer.sum(a, b);
        // 老师傅会着急的。


    }

    @Test
    public void test2() {
        // 普通的lambda写法。
        IA ia1 = () -> {
            System.out.println("A的实现。 ");
        };

        // 我在自己实现的时候。我不写代码。 我就调用别人，
        IA ia2 = () -> A.func1();
        IA ia3 = A::func1;
    }

    @Test
    public void test3() {
        // 如果想用别人写好的成员方法。 这时候也可以。
        IC ic1 = (a) -> {
            System.out.println(a);
        };
        C c = new C();

        IC ic3 = (a) -> c.func2(a);
        IC ic4 = c::func2;

    }

    @Test
    public void test4() {

        String dogName = "阿黄";
        int dogAge = 5;


        IE ie1 = (name, age) -> {
            return new Dog(name, age);
        };

        IE ie2 = Dog::new;
    }


}


@FunctionalInterface
interface IA {
    void testA();
}

class A {
    // 定义一个静态方法 作为IA接口中的testA方法的实现
    static void func1() {
        System.out.println("IA接口中的testA方法的实现");
    }
}

@FunctionalInterface
interface IB {
    void testB(String s);
}

@FunctionalInterface
interface IC {
    void testC(int a);
}

class C {
    void func2(int m) {
        System.out.println(m);
    }
}

@FunctionalInterface
interface ID {
    String testD(String s, int start, int end);
}

@FunctionalInterface
interface IE {
    Dog getDog(String a, int b);
}

@FunctionalInterface
interface IG {
    Dog getDog();
}


class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }
}

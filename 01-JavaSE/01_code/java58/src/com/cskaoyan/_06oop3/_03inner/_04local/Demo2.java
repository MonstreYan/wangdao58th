package com.cskaoyan._06oop3._03inner._04local;

/**
 * 局部内部类的用途： 就是为了继承外部类，实现外部接口。然后又不想让别人知道这个存在。
 *
 * @author Common-zhou
 * @since 2024-03-13 10:24
 */
public class Demo2 {
    public void test1() {
        // 局部内部类，可以继承和实现外部的类。 这个是它的一个重要用途。
        class Demo1 extends Demo2 {
        }
    }

    public Animal2 test2() {
        //
        // return new Animal2();

        // 局部内部类。
        class Dog3 extends Animal2 {
            @Override
            public String eat() {
                return "dog eat";
            }
        }

        // 现在想返回一个子类对象。  eat方法里面。返回值是  “dog eat”
        return new Dog3();
    }

    public Play test3() {
        // 方法如果想返回一个引用数据类型，这时候可以在方法的局部，定义一个局部内部类，来继承/实现这个类。
        // 最终创建局部内部类的对象返回
        class AirPlane implements Play {

            @Override
            public String play() {
                return "AirPlane fly";
            }
        }

        return new AirPlane();

    }
}


class Animal2 {
    public String eat() {
        return "animal2 eat";
    }
}


class Dog2 extends Animal2 {
    @Override
    public String eat() {
        return "dog eat";
    }
}

interface Play {
    String play();
}

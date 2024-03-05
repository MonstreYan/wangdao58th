package com.cskaoyan._04oop1._06constructor;

/**
 * 注意事项
 * 1. 类中默认提供的无参构造方法，是在该类没有任何构造器的情况下才有的。但是如果类中有任一构造器（有参/无参），
 * 那么就没有默认无参存在了
 * 2. 在构造器中也会隐含this传参, 我们可利用this对成员变量进行赋值, 也可以使用快捷键, alt + insert快速生成构造器.
 * 3. 构造器中还可以用this表示调用其它构造器，语法：
 * this(实参列表);
 * 表示调用类中的其它构造器，根据实参列表决定调用哪个构造器。
 *
 * @author Common-zhou
 * @since 2024-03-05 16:16
 */
public class Demo6 {

    public static void main(String[] args) {

        // 只要类中，有任意一个构造方法。 这时候，默认的无参构造方法就不存在了。
        // 如果你既想要无参构造方法，也想要有参构造方法， 这时候，自己写一个无参构造方法。
        // Expected 1 arguments but found 0
        // 无参构造方法。
        Cat6 cat6 = new Cat6();
    }
}

class Cat6 {
    private String color;
    private String name;
    // 假设存储的是体重的 g数
    private int weight;

    public Cat6() {
    }

    // 一参的构造方法。
    public Cat6(String color) {
        this.color = color;
    }

    // 构造器写法非常的固定，所以idea给了我们快捷的选项。
    // 可以自动生成这个构造器。
    // alt + inert
    // 要善于用idea。 或者善于运用idea给我们提供的方便。
    // sout  for  fori .  psvm
    // ecplice  ==> 可以找插件。
    public Cat6(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat6(String color, String name, int weight) {
        // 可以在一个构造器中，使用this 去调用其他的构造器。
        this(name, weight);
        this.color = color;
    }
}

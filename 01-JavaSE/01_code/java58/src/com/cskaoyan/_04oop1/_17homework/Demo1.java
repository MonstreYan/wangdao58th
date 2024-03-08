package com.cskaoyan._04oop1._17homework;

/**
 * @author Common-zhou
 * @since 2024-03-08 09:57
 */
public class Demo1 {

}


class Student1 {
    private String name;
    private int id;
    private int age;

    // 对构造方法有一个疑问。 为啥非得一个构造方法调用另外一个构造方法。
    // 在企业中，一般不这样写。
    // 有的在一些，核心代码中。可能确实有这种必要性。
    // 比如，你现在，要在构造方法中，计算一个非常复杂的参数，计算了之后设置进去。
    // 其他的情况，一般不需要这样套娃调用构造方法。
    // 大家写代码的时候，构造方法，不用使劲调。

    public Student1() {
        // 非常复杂的代码逻辑（）
    }


    // 非常复杂的代码逻辑（）
    public Student1(String name) {
        // 非常复杂的代码逻辑（）
        this.name = name;
    }

    public Student1(String name, int id) {
        // 非常复杂的代码逻辑（）
        this(name);
        // this.name = name;
        this.id = id;
    }

    public Student1(String name, int id, int age) {
        // 非常复杂的代码逻辑（）
        this(name, id);
        // this.name = name;
        // this.id = id;
        this.age = age;
    }
}

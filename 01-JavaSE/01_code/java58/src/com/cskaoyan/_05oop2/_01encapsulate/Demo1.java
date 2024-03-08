package com.cskaoyan._05oop2._01encapsulate;

/**
 * 封装是指的，将数据包在类结构里面，只对外提供想给外部访问的数据。
 * 封装（encapsulate）是指将数据及相关操作绑定在一起的一种编程机制，使其构成一个不可分割的独立实体。
 * 在Java中，类就是这样一种结构。当然，数据被保护在类的内部，是为了尽可能地隐藏内部的细节，
 * 只保留一些对外"接口"使之与外部发生联系。
 * <p>
 * 好处：
 * 1.使用者能够正常使用那些，我想让你使用的功能，方法。
 * 2.对于开发者/设计者来说，有一些内部使用的东西，我不想让你使用。 方便我下一次进行修改。
 * 3.可以对数据进行验证，保证安全合理
 *
 * @author Common-zhou
 * @since 2024-03-08 14:33
 */
public class Demo1 {
    public static void main(String[] args) {
        Student student = new Student();
        // 如果没有封装，可以通过这种方式设置值。 但是这个值，我们没有进行验证。 有时候会有问题。
        student.age = -10;
    }
}

class Student {
    public int age;

    // 别人如果不知道这个属性存在，你也没告诉别人 怎么设置，怎么获取。
    private String id;
}

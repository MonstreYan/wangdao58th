package com.cskaoyan._05oop2._02extends._11override;

import com.cskaoyan._05oop2._02extends._03convert.Father;

/**
 * 首先是 对象名点访问成员方法 ，对象的由来，可以有三种方式：
 * <p>
 * 1. 创建父类对象,用父类引用接收，用对象名点访问。
 * 2. 创建子类对象,用子类引用接收，用对象名点访问。
 * 3. 创建子类对象,用父类引用接收，用对象名点访问。
 *
 * @author Common-zhou
 * @since 2024-03-11 10:58
 */
public class Demo2 {
    public static void main(String[] args) {
        // 首先是 对象名点访问成员方法 ，对象的由来，可以有三种方式：
        // 1. 创建父类对象,用父类引用接收，用对象名点访问。
        Father2 father2 = new Father2();

        father2.fatherMethod();
        father2.commonMethod();
        System.out.println("================================");

        // 2. 创建子类对象,用子类引用接收，用对象名点访问。
        Son2 son2 = new Son2();

        son2.fatherMethod();
        son2.sonMethod();
        son2.commonMethod();

        System.out.println("================================");


        // 3. 创建子类对象,用父类引用接收，用对象名点访问。

        Father2 father = new Son2();
        father.fatherMethod();
        father.commonMethod(); // 到底调用的是谁的方法？  子类还是父类 。 子类的

        // 对于方法，编译看左边，运行看右边。
        // Father2 father = new Son2();
        // 编译看左边： 就是目前是个Father2引用，所以在编译阶段，能点出来的方法，就是Father2的方法。
        // father.commonMethod();
        // 运行看右边： 就是实际是什么类型，调用的就是这个类型的方法，
        // 因为实际的类型是一个Son2.所以在运行的时候，实际调用的就是子类自己的方法。
        father.commonMethod();
    }
}


class Father2 {
    public void fatherMethod() {
        System.out.println("father method");
    }

    public void commonMethod() {
        System.out.println("father print");
    }
}

class Son2 extends Father2 {
    public void sonMethod() {
        System.out.println("son method");
    }

    public void commonMethod() {
        System.out.println("son2 print");
    }

}

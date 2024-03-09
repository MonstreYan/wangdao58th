package com.cskaoyan._05oop2._02extends._08init;

/**
 * 子类的类加载会触发父类的类加载，并且类加载的顺序是"先父后子"的。
 *
 * 需要使用Star类。 Start类是继承Person的。 所以加载Star的时候。Person一定要完成类加载。
 * 而且顺序一定是先父后子。
 *
 * @author Common-zhou
 * @since 2024-03-09 10:06
 */
public class Demo2 {
    public static void main(String[] args) {
        Star star = new Star();
        System.out.println("star.agentName = " + star.agentName);
    }
}

class Person {
    String name = "i kun";
}

class Star extends Person {
    String agentName = "tao";
}

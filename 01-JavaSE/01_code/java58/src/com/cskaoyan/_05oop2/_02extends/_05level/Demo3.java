package com.cskaoyan._05oop2._02extends._05level;

/**
 * 1. 在一条继承链中，总称呼下游类是上游类的子类，不管隔了几层。没有孙子类或者重孙类这种概念。
 * 2. 在一条继承链中的，下游的类总是继承上游类的所有成员，不管隔了几层。
 * 3. 在一条继承链中，下游类总可以看成一个上游类，存在"is-a"关系。
 * 4. 不在同一条继承链中的类，没有任何关系。虽然看起来像"兄弟姐妹"类，但是Java是不讲究血统的。
 * - 因为一方面，子类可以自由扩展功能；另一方面，继承来的东西也是可以修改的。
 * - 所以"兄弟姐妹"可能完全和"我"不同，没有任何关系。
 * 5. 不能循环定义继承。比如A继承B，B继承C，再让C来继承A，这是不行的。
 * 6. 继承链可以无限延伸下去，但是一般来说有个5~6层继承，已经很多了。
 *
 * @author Common-zhou
 * @since 2024-03-08 17:21
 */
public class Demo3 {

    public static void main(String[] args) {
        // 在一条继承链上。下游类和上游类，有is-a关系.

        // Son3  is-a  Father3
        // GrandSon3 is-a Son3
        // GrandSon3 is-a  Father3
        // 怎么理解？ 因为GrandSon3里面有Father3里面的所有成员变量，成员方法。。


    }
}

class Father3 {
}

class Son3 extends Father3 {
}

class GrandSon3 extends Son3 {
}

class GrandSon31 extends Son3 {
}


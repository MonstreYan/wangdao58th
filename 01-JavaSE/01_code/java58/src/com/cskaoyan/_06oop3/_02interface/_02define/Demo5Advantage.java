package com.cskaoyan._06oop3._02interface._02define;

/**
 * 接口的优点：
 * 1.接口允许多实现。 但是继承只允许单继承
 * 在Java里面，继承资源，非常珍贵。 只允许继承一个，继承了一个就不能再继承别的了。
 * 但是接口允许多实现。
 * 所以推荐大家多使用接口。
 * 2.接口不是类，它和它的实现类，也不需要存在"is-a"关系，接口比抽象类的使用更加灵活。
 * - 程序开发中将接口和它的实现类之间的关系，称之为"like-a"关系。只要是实现了Xxx的功能，就像Xxx。
 *
 * 3.接口表示一种开发标准，一种规范。表示对功能的扩展，它只关注行为，不关注属性。
 *
 * @author Common-zhou
 * @since 2024-03-12 11:04
 */
public class Demo5Advantage {
    public static void main(String[] args) {
        // 如果用继承的话， 父类和子类，其实是is-a关系

        // 继承限制的更严格一些。 对于一些类。不允许使用继承。
        // Animal(fly)  ;   Dog  extends Animal
        //  Dog is-a Animal
        // AirPlane   extend Animal
        // AirPlane is-a Animal?

    }
}


interface Animal5 {
    // eat
}

interface Bird5 {
    //
}

// 只要实现了Fly接口。有没有里面方法？一定要实现。
// 方法代表了它的能力。  接口是 like-a 关系。
// 只要实现了接口，就说你like-a  .
class Sparrow5 implements Animal5, Bird5, Fly {

    @Override
    public void fly() {

    }
}

// 飞机有飞的能力。
// class AirPlane implements Fly {
//
// }

interface Fly {
    void fly();
}

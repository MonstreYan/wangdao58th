package com.cskaoyan._05oop2._03poly;

/**
 * instance关键字。
 * 多态的基本使用，是用父类引用，指向子类对象。如果在某个场景下，必须要访问子类的某些属性或方法，这时候直接是做不到的。
 * 必须要强转了之后，才能做到，只要强转，就可能出现异常。
 * Animal animal =new Dog();
 * Dog dog = (Dog)animal;
 * <p>
 * instanceof关键字。 用于检测是否是这个类型
 *
 * @author Common-zhou
 * @since 2024-03-11 16:29
 */
public class Demo5 {
    public static void main(String[] args) {
        Animal5 animal5 = new Dog5();

        // 多态。
        animal5.shout();

        // 但是，一旦你要使用Dog5的特有方法，就不行了。
        // animal5.watchHome();
        Dog5 dog5 = (Dog5) animal5;
        dog5.watchHome();


        // 有一个关键字，可以帮助我们检查，是否是这个类型。
        // 对象名 instanceof 类名
        boolean belongClass = animal5 instanceof Cat5;

        System.out.println("belongClass = " + belongClass);

        boolean belongDogClass = animal5 instanceof Dog5;

        System.out.println("belongDogClass = " + belongDogClass);

        // Cat5 cat5 = (Cat5) animal5;

        if (animal5 instanceof Cat5) {
            // 只要它进去说明。说明就是Cat5类型。
            Cat5 cat5 = (Cat5) animal5;
            cat5.playWithOther();
        } else {
            System.out.println("instance of  else branch ");
        }


    }
}


class Animal5 {
    public void shout() {
        System.out.println("animal shout");
    }

}

class Dog5 extends Animal5 {

    @Override
    public void shout() {
        System.out.println("狗汪汪叫。。。");
    }

    public void watchHome() {
        // 看门
        System.out.println("狗狗看门");
    }
}

class Cat5 extends Animal5 {

    @Override
    public void shout() {
        System.out.println("猫喵喵喵。。。");
    }

    public void playWithOther() {
        System.out.println("猫陪人玩");
    }
}

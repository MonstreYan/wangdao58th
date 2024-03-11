package com.cskaoyan._05oop2._03poly;

/**
 * 假设科学家要研究动物叫声。 动物对象里面有一个方法， 调用这个方法就可以获取到这个叫声
 * 科学家，要研究 狗  猫
 *
 * @author Common-zhou
 * @since 2024-03-11 16:18
 */
public class Demo4 {
    // 科学家要研究这些叫声，有多种方式
    // 1.为每一个动物，都去写一个方法。
    // public static void research(Cat4 cat4) {
    //     cat4.shout();
    // }
    //
    // public static void research(Dog4 dog4) {
    //     dog4.shout();
    // }

    // 2.科学家，写一个通用的方法，有什么好处。
    // 比如，传了一个 Dog4进来，调用的是谁的方法？ Dog4.   ===》  有多态保证的。
    public static void research(Animal4 animal4) {
        System.out.println("animal4.shout() = " + animal4.shout());
    }

    public static void main(String[] args) {
        research(new Cat4());
        research(new Dog4());
        research(new Batman());

    }


}

class Animal4 {
    public String shout() {
        return "动物叫";
    }
}


class Cat4 extends Animal4 {
    @Override
    public String shout() {
        return "猫叫";
    }
}

class Dog4 extends Animal4 {
    @Override
    public String shout() {
        return "狗叫";
    }
}


class Batman extends Animal4 {
    @Override
    public String shout() {
        return "蝙蝠叫";
    }
}

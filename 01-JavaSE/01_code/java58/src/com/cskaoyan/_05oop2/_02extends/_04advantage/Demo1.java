package com.cskaoyan._05oop2._02extends._04advantage;

/**
 * 在一款游戏中，我们设计了三种类型的鸭子，这些鸭子有一些共同的属性，也有共同的行为，比如都可以叫，都会游泳等。
 * 编写程序，描述这些鸭子。
 *
 * @author Common-zhou
 * @since 2024-03-08 16:43
 */
public class Demo1 {

    public static void main(String[] args) {
        // 在Java中程序中，一般情况下，使用该类引用指向该类。
        // 如果在一些特殊情况下，可以使用父类引用指向子类。
        // BaseDuck baseDuck = new ChouxiaoDuck();

        // 类型转换。
        // 自动类型转换： 子类引用，转成父类。 因为子类 is-a 父类。所以这个过程，不需要任何的代码协助
        // 强制类型转换：父类引用，转换成子类。 这时候就不能自动完成，需要手动写代码完成。
        // ChouxiaoDuck chouxiaoDuck = (ChouxiaoDuck) baseDuck;

        ChouxiaoDuck chouxiaoDuck = new ChouxiaoDuck();
        chouxiaoDuck.changeBeautiful();

        KedaDuck kedaDuck = new KedaDuck();
        kedaDuck.improve();

        TanglaoDuck tanglaoDuck = new TanglaoDuck();
        tanglaoDuck.speak();

    }
}


class BaseDuck {
    // 体重。年龄
    private int weight;
    private int age;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 叫和游泳 方法
    public void shout() {
        System.out.println("鸭子叫");
    }

    // 游泳
    public void swimming() {
        System.out.println("鸭子不能游泳了");
    }

    public void fly() {
        System.out.println("鸭子飞了");
    }
}

class ChouxiaoDuck extends BaseDuck {
    public void changeBeautiful() {
        System.out.println("丑小鸭变美");
    }
}

class TanglaoDuck extends BaseDuck {
    public void speak() {
        System.out.println("唐老鸭会说话");
    }
}

class KedaDuck extends BaseDuck {
    public void improve() {
        System.out.println("可达鸭进化");
    }
}

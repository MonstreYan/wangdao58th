package com.cskaoyan._04oop1._05this;

/**
 * 注意事项：
 * 1. this指向当前对象的隐含传参，必须是在普通成员方法中，加static的方法中，
 * 没有该this传参。（所以static方法不能直接访问类的成员，需要先创建对象才能访问。）
 * 2. 既然this指向当前对象，那么不同的this指向的对象必然不同。
 *
 * @author Common-zhou
 * @since 2024-03-05 15:16
 */
public class Demo5 {

    public static void main(String[] args) {
        // this指向的是当前对象。 所以不同对象的this必然不同
        Car5 car51 = new Car5();
        Car5 car52 = new Car5();
        car51.printThis();
        car52.printThis();

    }

}

class Car5 {
    public String name;
    public String color;

    // 这里会报错。 因为this只能在成员方法中使用。 不能在static方法中使用。
    // public static void test1() {
    //     System.out.println(this.name);
    // }

    public void printThis() {
        System.out.println(this);
    }

}

package com.cskaoyan._04oop1._02define;

/**
 * 对象的使用。
 * 1. 无论成员变量还是成员方法，都是属于对象的！必须创建对象才能访问它们！
 * 2. 实际上不同对象，访问类中同一个成员变量和成员方法的结果完全可能是不同的！！
 *
 * @author Common-zhou
 * @since 2024-03-04 17:26
 */
public class Demo5 {
    public static void main(String[] args) {
        // 创建一个对象。  格式
        // 类名 对象名 = new 类名();
        Dog dog = new Dog();

        // 1.直接输出对象名: 只要打印引用数据类型，出来就是 地址。
        // com.cskaoyan._04oop1._02define.Dog@682a0b20
        System.out.println(dog);

        // 2.可以通过对象。来访问对象的属性和方法。
        // 2.1访问属性
        // 数据类型 变量名 = 对象名.成员变量;  ==》 获取
        int age = dog.age;
        System.out.println("狗狗的年龄：" + age);
        System.out.println(dog.name);

        // 2.2.修改属性
        dog.age = 3;
        dog.name = "柯基";
        dog.color = "黄白";

        System.out.println(dog.name);

        // 而具体默认值是什么，也和数组对象中的元素一致。
        // new int[5]  ==>  int 的默认值：0


        // 2.3访问方法
        // 对象名.成员方法名(实参);
        dog.eat();
    }
}

// 创建一个狗。 狗里面有 年龄、名字、颜色
// 狗可以吃东西，可以睡觉
class Dog {
    // 这个就是一个类。 是一个模板。 我们可以在这个模板中去定义 有哪些属性，有哪些方法。
    // 在类里面定义属性。格式
    // [权限修饰符] 数据类型  成员变量名;   ===>  权限修饰符先写public
    public int age;
    public String name;
    public String color;

    // 在类中可以定义方法， 格式
    // [权限修饰符] 返回值类型  方法名(形参列表){}   ==》  权限修饰符，先写public
    public void eat() {
        System.out.println(name + "这只狗狗，正在吃东西");
    }

    public void sleep() {
        System.out.println(name + "这只狗狗，正在睡觉");
    }


}




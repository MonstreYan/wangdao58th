package com.cskaoyan._05oop2._02extends._08init;

/**
 * 现在我们学习了继承的概念，在继承中，子类会继承父类的成员，使用子类对象可以直接访问父类中继承过来的成员。
 * 那么问题就来了：
 * 1. 父类的成员从何而来？凭空出现？
 * 2. 父类的成员变量也需要赋值，那么赋值顺序是怎么样的？结果是怎么样的？为什么会体现出这种特点？
 * <p>
 * 这个肯定是JVM底层进行了处理之后，才会看到这个父类的成员变量。
 *
 * @author Common-zhou
 * @since 2024-03-09 09:55
 */
public class Demo1 {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        String fatherName = son1.fatherName;
    }
}


class Father1 {
    String fatherName = "fatherName1111";
    int fatherAge = 50;
}


class Son1 extends Father1 {
    String sonName = "sonName";

    public void showInfo() {
        System.out.println(this.fatherName);
        System.out.println(this.fatherAge);
        System.out.println(this.sonName);
    }

}

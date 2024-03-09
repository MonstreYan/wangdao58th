package com.cskaoyan._05oop2._02extends._00homework.a;

/**
 * clone方法是java.lang包下Object类，当中的一个受保护访问权限的成员方法
 * protected
 * <p>
 * 现有以下类:
 * a包下的public Student类
 * b包下的public Student类
 * a包下的public Test类
 * 以下关于clone方法的调用，说法是正确的是（不考虑异常，只考虑访问权限）：
 * <p>
 * protected： 在哪里能访问？同类、同包、不同包中子类对象访问。
 * 传递变量，但是这个这个变量，只想给子类访问。
 * <p>
 * <p>
 * A: 在a包下Student类的成员方法中可以直接调用clone方法   √
 * B: 在b包下Student类的静态成员方法中可以直接调用clone方法 ×
 * C: 在a包下Test类的方法中，创建a包下Student类的对象，可以直接调用clone方法  ×
 * D: 在a包下Test类的方法中，创建b包下Student类的对象，不可以直接调用clone方法  √
 * E: 在a包下Test类的静态方法中，必须创建自身Test对象才能够调用clone方法 √
 * F: 在a包下Test类的成员方法中，也必须新建自身Test对象才能够调用clone方法  ×
 *
 * @author Common-zhou
 * @since 2024-03-09 09:34
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        // 'clone()' has protected access in 'java.lang.Object'
        // student.clone();

        // protected 只允许在同类、同包、 不同包的子类对象中访问。

        // ======================
        // 在不同包的子类下访问。 这里必须要创建子类对象（成员方法中，为什么没有创建子类对象。 ）
        // 其他情况，都不允许访问。
    }

    public void test2() throws CloneNotSupportedException {
        this.clone();
    }
}

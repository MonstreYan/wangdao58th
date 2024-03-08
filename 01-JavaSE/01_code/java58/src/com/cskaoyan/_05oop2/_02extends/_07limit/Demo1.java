package com.cskaoyan._05oop2._02extends._07limit;

/**
 * 子类，能否继承父类的静态成员变量
 *
 * 首先，如果子类没有父类中的同名静态成员时，直接用子类类名点访问，是可以访问到父类中的静态成员的。
 * 但这仅意味着子类能够使用父类的静态成员，并不意味着继承！通常情况下，继承仅考虑普通成员而不考虑静态成员。
 *
 * @author Common-zhou
 * @since 2024-03-08 17:49
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(Son.num);
    }
}

class Father {
    static int num = 10;
}

class Son extends Father {

}

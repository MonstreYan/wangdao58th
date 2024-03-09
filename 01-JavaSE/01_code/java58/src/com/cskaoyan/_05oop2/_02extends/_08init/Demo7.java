package com.cskaoyan._05oop2._02extends._08init;

/**
 * 1. super只能访问父类中有的成员，特殊情况下，当父子类具有同名成员时，可以用super区分。
 * 2. this在当前类中不受访问权限控制，super访问父类成员，受访问权限控制。
 * 3. this毕竟还是一个引用，指向当前对象，所以可以直接在类中成员方法中输出它。
 * 但是super毕竟没有指向对象，无法直接输出它！
 *
 * @author Common-zhou
 * @since 2024-03-09 10:58
 */
public class Demo7 {
    public static void main(String[] args) {
        Son7 son7 = new Son7();
        son7.test1();
    }
}

class Father7 {
    private String privateFatherName = "privateFatherName";
    String defaultFatherName = "defaultFatherName";
    public String publicFatherName = "publicFatherName";
}


class Son7 extends Father7 {
    private String privateSonName = "privateSonName";
    String defaultSonName = "defaultSonName";
    public String publicSonName = "publicSonName";

    // super关键字，完全"近似"可以当做一个指向父类的引用。
    // 可以当做，创建了一个父类对象。 ====》但是实际是没有创建父类对象
    public void test1() {
        // 1.super可以用于方法父类的成员变量。 尤其是当出现父子类同名的时候
        // super
        // 这个，能不能再静态方法中用？  ==》  一定不能。
        System.out.println("super.publicFatherName = " + super.publicFatherName);

        // 2.this指向当前对象。它访问成员变量不受权限控制。 super代表父类对象，受访问权限控制
        System.out.println("this.privateSonName = " + this.privateSonName);
        // String privateFatherName = super.privateFatherName;

        // 3.this毕竟还是一个引用，指向当前对象，所以可以直接在类中成员方法中输出它。
        // 但是super毕竟没有指向对象，无法直接输出它！
        System.out.println(this); // 全限定类名 + @ +地址
    }

}

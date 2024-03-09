package com.cskaoyan._05oop2._02extends._08init;

/**
 * 父子类的实例化顺序是怎样的？
 *
 * 先父后子。
 * @author Common-zhou
 * @since 2024-03-09 10:30
 */
public class Demo5 {
    public static void main(String[] args) {
        Son5 son5 = new Son5();
    }
}

class GrandFather5 {
    String grandFatherName = "grandFatherName";

    public GrandFather5() {
        System.out.println("GrandFather init");
    }
}

class Father5 extends GrandFather5 {
    String fatherName = "fatherName";

    public Father5() {
        System.out.println("father init");
    }
}

class Son5 extends Father5 {
    String sonName = "sonName";

    public Son5() {
        System.out.println("Son init");
    }
}

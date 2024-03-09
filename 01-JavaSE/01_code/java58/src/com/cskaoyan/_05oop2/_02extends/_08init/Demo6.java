package com.cskaoyan._05oop2._02extends._08init;

/**
 * @author Common-zhou
 * @since 2024-03-09 10:40
 */
public class Demo6 {
}

class Father6 {
    String fatherName = "fatherName";

    public Father6() {
        System.out.println("father init");
    }
}

class Son6 extends Father6 {
    String sonName = "sonName";

    public Son6() {
        // super 必须在第一行， this也必须在第一行。
        // 所以它们不能同时使用在一个方法里面。
        super();
        // this();
        System.out.println("Son init");
    }
}

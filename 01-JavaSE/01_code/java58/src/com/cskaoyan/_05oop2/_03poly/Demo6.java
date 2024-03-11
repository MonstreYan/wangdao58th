package com.cskaoyan._05oop2._03poly;

/**
 * @author Common-zhou
 * @since 2024-03-11 16:40
 */
public class Demo6 {
    public static void main(String[] args) {
        // Father father = new Father();
        // Father father = new Son();

        // 没问题。
        // Father father = new GrandSon();

        Father father = new GrandSon();

        Son son = (Son) father;


        GrandSon grandSon = (GrandSon) father;

        // Father  father = new GrandSon();
        // 现在这个father。能转成哪些类型？

        // Father father = new Son();
        // Son son = (Son)father;
        // GrandSon son = (GrandSon)father;

    }

}

class Father {
}

class Son extends Father {
}

class GrandSon extends Son {
}

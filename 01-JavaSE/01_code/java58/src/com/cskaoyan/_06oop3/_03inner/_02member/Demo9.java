package com.cskaoyan._06oop3._03inner._02member;

/**
 * @author Common-zhou
 * @since 2024-03-12 17:53
 */
public class Demo9 {
    public static void main(String[] args) {

    }
}


class OuterClazz9 {

    public int num = 10;

    class InnerClass9 {
        public int num = 20;

        public void test1() {
            int num = 30;

            // 想访问外部类成员变量： 外部类名.this.成员变量名
            System.out.println("OuterClazz9.this.num = " + OuterClazz9.this.num);

            // 想访问内部类成员变量： this.成员变量名
            System.out.println("this.num = " + this.num);

            // 想访问 局部变量。 直接写。
            System.out.println("num = " + num);
        }
    }

    public static void main(String[] args) {
        // 能， 先创建外部类对象，再创建内部类对象，再去访问。
        OuterClazz9 outerClazz9 = new OuterClazz9();

        // InnerClass9 innerClass9 = outerClazz9.new InnerClass9();
    }
}

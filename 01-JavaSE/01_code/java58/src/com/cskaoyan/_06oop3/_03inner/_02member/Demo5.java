package com.cskaoyan._06oop3._03inner._02member;

/**
 * 内部类访问外部类成员
 *
 * @author Common-zhou
 * @since 2024-03-12 16:29
 */
public class Demo5 {

}

class OuterClazz5 {
    private String privateOuterName = "privateOuterName";
    String defaultOuterName = "defaultOuterName";
    public String publicOuterName = "publicOuterName";

    String m1 = "outerM1Value";
    String m2 = "outerM2Value";

    class InnerClazz5 {

        String m1 = "innerM1Value";
        String m2 = "innerM2Value";

        public void test1() {
            // 在这里面，是不是可以写成员方法。
            // 在成员方法里面，对象目前有没有？
            // 内部类肯定有对象。  外部类对象一定有的。
            // 直接访问。 以为内部类有对象，外部类也有对象。 ==> 直接访问

            // 在成员方法中，因为内部类对象有，外部对象也有。所以可以直接访问。
            System.out.println(privateOuterName);
            System.out.println(defaultOuterName);
            System.out.println(publicOuterName);
        }

        public void test2() {
            // 在内部类的成员方法中，可以直接访问外部类的成员。
            // 在一些特殊情况下。 同名。这个时候的访问规则： 按照就近原则。
            // 1.如果局部变量有，拿到的就是局部变量的值
            // 2.如果局部变量无，内部类成员变量有，拿到的就是内部类成员变量的
            // 3.如果俩都没有，拿到的才是外部类对象的。

            String m2 = "test2MethodValue";
            System.out.println("m1 = " + m1);
            System.out.println("m2 = " + m2);
        }

        public void test3() {
            // 如果同名的时候，我还是想拿外部类的变量，内部类的变量。怎么拿
            // 局部变量：直接写名字即可。
            // 内部类的成员变量： this
            System.out.println("this.m1 = " + this.m1);
            // 外部类的成员变量： 外部类名.this.m2 ==> 拿外部类的成员变量

            System.out.println("OuterClazz5.this.m1 = " + OuterClazz5.this.m1);

        }
    }

    public static void main(String[] args) {
        // 创建内部类对象的前提： 外部类对象一定要存在。

        // InnerClazz5
        // 创建内部类对象的一个语法。 一定要先创建外部类对象，再创建内部类对象
        InnerClazz5 innerClazz5 = new OuterClazz5().new InnerClazz5();

        // innerClazz5.test2();
        innerClazz5.test3();


        // 内部类对象，是定义在外部类对象成员位置的一个变量。 所以如果需要内部类对象，
        // 一定要先创建外部类对象， 或者说有这个外部类对象就行
        // InnerClazz5 innerClazz51 = new InnerClazz5();
        OuterClazz5 outerClazz5 = new OuterClazz5();

        InnerClazz5 innerClazz52 = outerClazz5.new InnerClazz5();

        // new OuterClazz5().InnerClazz5();
    }

    public void test3() {
        // 在这，有没有外部类对象？
        // 这是成员方法， 成员方法属于对象。  ==》 在这有外部类对象
        InnerClazz5 innerClazz5 = new InnerClazz5();
    }

}

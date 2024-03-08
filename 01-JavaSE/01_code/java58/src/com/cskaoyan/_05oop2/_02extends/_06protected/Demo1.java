package com.cskaoyan._05oop2._02extends._06protected;

import com.cskaoyan._04oop1._16modifier2.pack1.Student;

/**
 * 什么是访问权限：
 * 1.在Java中，想控制，有一些代码，别人能看到。 有些代码，别人看不到。 这种，我们就可以使用访问权限来控制。
 * <p>
 * 2.访问权限有哪些。
 * <pre>
 *                    同类          同包       不同包子类     不同包
 *      private        *
 *      默认（缺省）     *             *
 *      protected     *             *           *
 *      public        *            *            *            *
 * </pre>
 * <p>
 * protected： 就是一个关键字。 用来给不同包的子类使用。
 * 因为有一些变量，觉得对子类比较有用，但是又觉得，只能给子类使用。   （
 * private 银行账户密码。 又认为子类对这个属性有需要。 ）
 * protected: 在不同包，但是如果是子类的话，可以访问这个属性。
 * <p>
 * protected是留给，不同包的子类来使用的。 但是一定要注意。 一定要创建子类对象才能使用它
 * 在成员方法中，可以使用，主要原因为，成员方法，属于对象，所以已经默认有一个对象。
 *
 * @author Common-zhou
 * @since 2024-03-08 17:29
 */
public class Demo1 {
    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.test1();
        // student1.testPrivateMethod();

        // student1.privateStringName
    }
}

class Student1 {
    private String privateStringName;

    public void test1() {
        System.out.println(privateStringName);
    }

    private void testPrivateMethod() {
        System.out.println(privateStringName);
    }


}

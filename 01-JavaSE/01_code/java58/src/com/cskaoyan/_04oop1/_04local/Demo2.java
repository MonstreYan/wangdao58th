package com.cskaoyan._04oop1._04local;

/**
 * 局部变量和成员变量的区别。
 * <p>
 * 在内存中的位置不同
 * 1. 局部变量存储在栈上的栈帧中
 * 2. 成员变量存储在堆中的对象中
 *
 *
 * 生命周期不同
 * 1. 局部变量随着方法的执行，而被创建，随着方法的执行结束就会被销毁。局部变量和方法"同生共死"。
 * 2. 成员变量在对象创建以后就存在了，对象被销毁回收内存自然就不存在了。
 *    但实际上只要该对象栈上的引用被销毁，对象成为"垃圾"，对象中的成员变量也就失去意义了。
 *
 *    但是不会被立刻销毁掉。会等GC。
 *
 * @author Common-zhou
 * @since 2024-03-05 11:47
 */
public class Demo2 {
    public static void main(String[] args) {
        Teacher2 teacher2 = new Teacher2();

        String name = "景天";

        test1();
    }

    private static void test1() {
        // 局部变量。
        int age = 10;
        String name = "test1";
    }
}

class Teacher2 {
    public String name;
}

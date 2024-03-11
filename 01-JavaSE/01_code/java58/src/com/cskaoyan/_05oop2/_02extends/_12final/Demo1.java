package com.cskaoyan._05oop2._02extends._12final;

/**
 * final表示最终，最后的意思。
 * 可以修饰   class  方法  变量
 * 1.final修饰类。 表示该类是最终的类，最后的类。 该类不允许被继承
 *
 * @author Common-zhou
 * @since 2024-03-11 11:48
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("1");
        // idea在处理编译的问题的时候，需要你强制解决所有编译问题。之后才允许你运行代码
        // 换句话说，只要你的 代码里，有任何编译时问题。都不能运行
        // 所以今后碰到编译问题，一定要及时解决。

        // 在工作过程中，我们一般不在自己的类上加final
        String s = "hello";
    }
}


final class Animal1 {
}

// Cannot inherit from final 'com.cskaoyan._05oop2._02extends._12final.Animal1'
// class Dog1 extends Animal1 {
// }

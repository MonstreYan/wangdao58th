// package com.cskaoyan._04oop1._13package;
// // Package name 'com.cskaoyan._04oop1._11anonymous' does not
// // correspond to the file path 'com.cskaoyan._04oop1._13package'
//
// /**
//  * 匿名对象： 在Java中，就是指的没有名字的对象
//  *
//  * @author Common-zhou
//  * @since 2024-03-07 15:01
//  */
// public class MyArraySort {
//     public static void main(String[] args) {
//         // 匿名对象。  没有名字的对象，或者说没有引用指向的对象
//
//
//         // 作用：
//         // 使用匿名对象作为方法的实参
//         // 当定义以下方法时，表示该方法需要传入一个对象（这个对象必须是"类名"的对象或者子类对象）
//
//         new Demo1();
//         Demo1 demo1 = new Demo1();
//
//         // 这个就叫做匿名对象。 传入test1方法的。
//         demo1.test1(new Demo1());
//
//
//         // 可以帮助我们适当简化代码
//         new Demo1().test1(null);
//
//     }
//
//     // 形参是一个Demo1  怎么传实参。
//     public void test1(Demo1 demo1) {
//
//     }
//
//     public Student1 test2() {
//         // 返回值类型。
//         // void
//         // int
//         // String
//
//         // 匿名对象。
//         return new Student1();
//     }
//
// }
//

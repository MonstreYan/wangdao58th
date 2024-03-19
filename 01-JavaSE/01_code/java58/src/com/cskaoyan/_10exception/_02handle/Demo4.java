package com.cskaoyan._10exception._02handle;

/**
 * JVM处理异常的逻辑过于简单粗暴。有时候不是我们想要的。 程序员可以自己选择如何处理这个异常。 主要就是使用
 * <p>
 * try关键字
 * catch
 * <p>
 * 语法：  try{  // 怀疑有问题的代码。 }
 * catch(异常类型 e){
 * <p>
 * // 你告诉JVM 异常的处理逻辑
 * }
 *
 * @author Common-zhou
 * @since 2024-03-19 10:35
 */
public class Demo4 {
    public static void main(String[] args) {

        int i = 10;
        System.out.println(i);

        try {
            // 怀疑有问题的代码或者方法，都可以放在try里面
            System.out.println("i1 before");
            int i1 = i / 0;
            System.out.println("i1 after");
        } catch (Exception e) {
            // 代表抓住了这个异常，就进入这个大括号】
            // 在这里面，就是你需要告诉JVM的处理流程。
            System.out.println("有异常了.....");
        }

        // try-catch 代码的执行
        // 1.从上往下执行。  在try-catch也是一行一行执行
        // 2.在try-catch中，一旦出现异常。 下面的代码不会执行了。 这时候JVM还是干老本行。 （异常信息的收集，封装，生成了一个异常对象）
        // 3.异常信息往上抛。 会进入到catch里面。
        // 4.进入catch内部的异常处理流程。

    }

}

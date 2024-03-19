package com.cskaoyan._10exception._01introduct;

/**
 * 根据处理方式的不同
 * - 编译时异常 : 编译不通过(除了RuntimeException及其子类外的其他的异常)。 都是编译时异常。
 * - 运行时异常: 编译通过, 但是运行时可能会出错(RuntimeException及其子类)
 *
 * @author Common-zhou
 * @since 2024-03-19 09:55
 */
public class Demo3 {
    public static void main(String[] args) {
        test1();

        test2();
    }

    private static void test2() {
        String str = null;

        // NullPointerException   数组越界异常。  算数异常。
        str.length();
    }

    private static void test1() {
        // 编译时异常： 就是在编译期就开始报错。如果不处理，程序运行不了。
        // FileInputStream inputStream = new FileInputStream("1.txt");
    }


}

package com.cskaoyan._01basic._05scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 09:34
 */
public class Demo1 {
    public static void main(String[] args) {
        // Scanner就是从键盘上录入数据的。 我们目前的数据都是写死的，
        // 我输入多少，就循环多少次。  ===》 就需要借助Scanner

        // 循环n次.
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Scanner的使用，分为三步.
        // 1.导包
        // 2. 创建对象Scanner sc = new Scanner(System.in);
        // 3.获取数据。  sc.nextInt();
    }


}

package com.cskaoyan._04oop1._18oop;

/**
 * 使用面向过程来完成做饭这个步骤。
 * - 买菜
 * - 洗菜
 * - 炒菜
 * - 洗锅
 * - 收拾
 *
 * @author Common-zhou
 * @since 2024-03-08 11:32
 */
public class Demo1 {

    public static void main(String[] args) {
        // 面向过程解决问题的思路： 使用一个一个的方法，来完成步骤。 最终调用这个方法
        buyDish();

        washDish();

        cookDish();

        washPot();

        tidyUp();
    }

    public static void buyDish() {
        System.out.println("吭哧吭哧在买菜");
    }

    public static void washDish() {
        System.out.println("稀里哗啦在洗菜");
    }

    public static void cookDish() {
        System.out.println("做菜中，勿扰");
    }

    public static void washPot() {
        System.out.println("洗锅洗锅洗锅");
    }

    public static void tidyUp() {
        System.out.println("洗刷刷，打扫中");
    }


}

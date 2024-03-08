package com.cskaoyan._04oop1._18oop;

/**
 * 面向对象： 就是用一个一个的对象，来完成功能。
 * 找专业的人，干专业的事。
 * - 买菜
 * - 洗菜
 * - 炒菜
 * - 洗锅
 * - 收拾
 * 找个厨子来干事。
 *
 * 可以把所有相关的功能，全部集中到一个类。
 *
 * @author Common-zhou
 * @since 2024-03-08 11:37
 */
public class Demo2 {
    public static void main(String[] args) {
        Chef chef = new Chef();

        chef.giveMoneyAndCook();
    }
}


// 这是一个厨师，厨师主要负责
class Chef {
    public void giveMoneyAndCook() {
        buyDish();
        washDish();
        cookDish();
        washPot();
        tidyUp();
    }

    public void buyDish() {
        System.out.println("吭哧吭哧在买菜");
    }

    public void washDish() {
        System.out.println("稀里哗啦在洗菜");
    }

    public void cookDish() {
        System.out.println("做菜中，勿扰");
    }

    public void washPot() {
        System.out.println("洗锅洗锅洗锅");
    }

    public void tidyUp() {
        System.out.println("洗刷刷，打扫中");
    }
}

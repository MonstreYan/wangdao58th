package com.cskaoyan._04oop1._10static;

/**
 * 一场篮球比赛, 梦之队有5名顶级球员Kobe, James...... 都是神射手擅长投3分,投篮必进
 * 每进一球, 队伍分数+3, 比赛结束, 统计一下该队伍得分情况,  写程序模拟这个场景.
 * <p>
 * 哪个是类。哪些是对象？
 * <p>
 * <p>
 * 在Java中，写代码。基本就是用类、 用对象来模拟世界。
 *
 * @author Common-zhou
 * @since 2024-03-07 10:22
 */
public class Demo1 {

    public static void main(String[] args) {

        Player play1 = new Player("科比", 200);
        Player play2 = new Player("詹姆斯", 200);
        int score = 0;

        // 对于一个球队来说，投篮了之后。 分数得记上。
        play1.shoot();
        score += 3;

        play2.shoot();
        score += 3;
        // 假设还有一些其他球员

        System.out.println("这只队伍得分：" + score);

        // 分开的。  score 和 球员分开了。

    }
}

class Player {
    // 球员有哪个属性。
    public String name;
    public int height;


    // 什么是构造方法？ 创建对象的时候，想给这个对象赋的一些属性。 这个就是构造方法， 出厂就设置好的属性
    public Player(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // Player里面有什么方法？

    // 投篮
    // public void toulan() {
    public void shoot() {
        // xiaowangdefuqin
        // xwdfq
        // 不要走捷径。 命名的时候不要投篮。   不要用拼音。
        // 表里面字段有300个。 全是拼音缩写。   phone
        // 屎山。   屎山上雕花。
        System.out.println(name + "投篮了， 进了");
    }

}

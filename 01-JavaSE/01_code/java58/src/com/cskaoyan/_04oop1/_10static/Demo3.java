package com.cskaoyan._04oop1._10static;

/**
 * @author Common-zhou
 * @since 2024-03-07 11:00
 */
public class Demo3 {
    public static void main(String[] args) {
        // 现在，我们想让这个球队的人，投篮之后就加分。
        // 弄一个静态成员变量。 因为静态成员变量是属于类的。
        Player3 play1 = new Player3("科比", 200);
        Player3 play2 = new Player3("詹姆斯", 200);

        // 对于一个球队来说，投篮了之后。 分数得记上。
        play1.shoot();
        play2.shoot();
        // 假设还有一些其他球员

        int score = Player3.score;
        System.out.println(score);
    }
}

class Player3 {
    // 球员有哪个属性。
    public String name;
    public int height;
    // 代表球队的总分。
    public static int score;

    public Player3(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // 投篮
    public void shoot() {
        score += 3;
        System.out.println(name + "投篮了， 进了");
    }
}

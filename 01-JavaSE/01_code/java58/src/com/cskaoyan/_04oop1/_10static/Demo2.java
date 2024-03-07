package com.cskaoyan._04oop1._10static;

/**
 * 静态成员：
 * [访问权限修饰符] static 数据类型 变量名;
 *
 * @author Common-zhou
 * @since 2024-03-07 10:37
 */
public class Demo2 {
    public static void main(String[] args) {
        // - 和普通成员变量一样,都具有默认值（默认值和普通成员变量是一样的）
        // - 静态成员变量属于类的，完全不需要创建对象使用。
        // - 访问和使用静态成员变量不推荐使用"对象名."，而应该使用"类名."！
        // - 静态成员变量的访问/赋值/使用都不依赖于对象, 而是依赖于类

        int score = Player2.score;
        System.out.println(score);

        String ballTeamName = Player2.ballTeamName;
        System.out.println(ballTeamName);


        Player2 player2 = new Player2();
        // 使用对象名，可以点出来静态成员变量。 但是不推荐使用。 推荐使用 类名.静态成员变量。
        int score1 = player2.score;
    }
}

class Player2 {
    // 想在这个类里面，定义静态成员变量。
    // [访问权限修饰符] static  数据类型  变量名;
    public static int score;

    // 引用数据类型。 默认值是null
    // 球队名。
    public static String ballTeamName;


}

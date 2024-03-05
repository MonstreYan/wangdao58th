package com.cskaoyan._04oop1._02define;

/**
 * // 如果说有另外一个场景。   比如，手机有很多。  需要记录手机的  CPU  价格  重量  运行内存
 * // 手机可以打游戏。 输出。什么手机(cpu),正在打游戏
 * // 在这个案例中，什么是类，什么是对象。
 * 手机是一个类。    iphone15   huaweimate60  xiaomi14
 *
 * @author Common-zhou
 * @since 2024-03-05 11:00
 */
public class Demo7Review {
    public static void main(String[] args) {
        // iphone15   huaweiMate60Pro   xiaomi14

        Phone iphone15 = new Phone();
        iphone15.name = "iphone15";
        iphone15.cpu = "A16";

        // iphone15.cpu

        Phone huaweiMate60 = new Phone();
        huaweiMate60.name = "huaweiMate60";
        huaweiMate60.cpu = "麒麟9000s";

        Phone xiaomi14 = new Phone();
        xiaomi14.name = "xiaomi14";
        xiaomi14.cpu = "晓龙8gen3";

        iphone15.playGame();

        // 类其实就是模板。 我们在不同的场景下，会定义不同类。 定义类之后，可以帮助我们将数据组合在一起。
        // 而不是分散着。

    }
}


class Phone {
    // CPU  价格  重量  运行内存
    public String name;
    public String cpu;
    public double price;
    public int weight;
    public int memory;

    public void playGame() {
        System.out.println(name + "(" + cpu + ")" + "正在打游戏......");
    }

}


package com.cskaoyan._18generic.d03;

/**
 * 小汽车
 * 假设小汽车里面有一个方法。 run。
 *
 * @author Common-zhou
 * @since 2024-03-27 09:37
 */
public class AutoCar implements Car {
    @Override
    public void run() {
        System.out.println("小汽车跑跑跑。。。。。。");
    }

    public void openSkyLight() {
        System.out.println("小汽车打开天窗......");
    }
}

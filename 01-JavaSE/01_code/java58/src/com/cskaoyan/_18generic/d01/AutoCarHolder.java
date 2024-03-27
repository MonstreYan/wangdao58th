package com.cskaoyan._18generic.d01;

/**
 * 车库类。 主要的作用就是用来存放车。 需要对外提供一个获取车的方法
 * <p>
 * 面向对象： 就是Java用来模拟世界的一套东西。
 *
 * @author Common-zhou
 * @since 2024-03-27 09:38
 */
public class AutoCarHolder {
    // 成员变量、静态变量。
    private AutoCar autoCar;

    public AutoCarHolder(AutoCar autoCar) {
        this.autoCar = autoCar;
    }

    public AutoCar get() {
        return this.autoCar;
    }

}

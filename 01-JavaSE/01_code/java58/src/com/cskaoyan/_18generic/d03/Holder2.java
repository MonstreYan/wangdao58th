package com.cskaoyan._18generic.d03;

/**
 * 车库类： 使用接口来接数据
 *
 * @author Common-zhou
 * @since 2024-03-27 10:14
 */
public class Holder2 {
    private Car car;

    public Holder2(Car car) {
        this.car = car;
    }

    public Car get() {
        return this.car;
    }
}

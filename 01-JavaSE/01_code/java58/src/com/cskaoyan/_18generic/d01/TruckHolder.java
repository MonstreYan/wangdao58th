package com.cskaoyan._18generic.d01;

/**
 * 用来存放卡车的。 对外提供获取的方法，获取这个卡车
 *
 * @author Common-zhou
 * @since 2024-03-27 09:52
 */
public class TruckHolder {
    private Truck truck;

    public TruckHolder(Truck truck) {
        this.truck = truck;
    }

    public Truck get() {
        return this.truck;
    }
}

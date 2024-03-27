package com.cskaoyan._18generic.d04;

import org.junit.Test;

/**
 * 使用泛型来解决这个问题
 *
 * @author Common-zhou
 * @since 2024-03-27 10:22
 */
public class Demo1 {
    @Test
    public void test1() {
        Holder3<AutoCar> holder3 = new Holder3<>(new AutoCar());

        AutoCar autoCar = holder3.get();

        autoCar.run();
        autoCar.openSkyLight();

        Holder3<Truck> truckHolder3 = new Holder3<>(new Truck());
        Truck truck = truckHolder3.get();
        truck.run();
    }

}

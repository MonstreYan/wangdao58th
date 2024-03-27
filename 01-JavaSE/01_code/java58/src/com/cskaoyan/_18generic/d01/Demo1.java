package com.cskaoyan._18generic.d01;

import org.junit.Test;

/**
 * - 汽车类
 * - 汽车的车库(主要用于存放车)。还提供一个方法获取汽车。
 * <p>
 * 成员变量。  Car  car;
 * <p>
 * <p>
 * 卡车类。
 * 卡车的车库类（主要用于存放卡车）。
 *
 *
 *
 * @author Common-zhou
 * @since 2024-03-27 09:35
 */
public class Demo1 {

    public static void main(String[] args) {
        // 现在就来用这个车库类。

        AutoCar autoCar = new AutoCar();

        AutoCarHolder autoCarHolder = new AutoCarHolder(autoCar);

        AutoCar autoCar1 = autoCarHolder.get();

        autoCar1.run();
    }

    @Test
    public void test2() {
        // 有点多余的感觉。
        AutoCar autoCar = new AutoCar();

        AutoCarHolder autoCarHolder = new AutoCarHolder(autoCar);
        AutoCar autoCar1 = autoCarHolder.get();

        // 现在用来模拟的小汽车非常简单。
        // 有时候，这个小汽车的生产工序非常复杂。
        // 引擎、轮胎、玻璃、车架  ===》 组装。

        // AutoCar autoCar2 = new AutoCar();
        // new AutoCar();
        // setEnginge();
        // setGlass();
        // setShelf();

        // 工序非常的麻烦。 所有有可能这个小汽车是别的程序员提供（专门负责组装小米汽车。 ）

        autoCar.run();
    }


    @Test
    public void test3() {
        // getAutoCarHolder 这个方法有可能是别人写。别人直接给一个车库我用。 告诉
        AutoCarHolder autoCarHolder = getAutoCarHolder();

        AutoCar autoCar = autoCarHolder.get();

        autoCar.run();
    }

    private AutoCarHolder getAutoCarHolder() {

        // 小米汽车的程序员。 步骤1 步骤2 步骤3 步骤4 步骤4.。。。。。。。
        AutoCar autoCar = new AutoCar();

        AutoCarHolder autoCarHolder = new AutoCarHolder(autoCar);

        return autoCarHolder;
    }


    @Test
    public void testTruckDemo() {
        Truck truck = new Truck();
        TruckHolder truckHolder = new TruckHolder(truck);

        Truck truck1 = truckHolder.get();
        truck1.run();
    }
}

package com.cskaoyan._03array;

import org.junit.Test;

/**
 * 设计物品（Item）类
 * 它具有以下属性：
 * 1. 名字
 * 2. 价格
 * 3. 类别
 * <p>
 * 它具有以下行为：
 * 1. 售卖。该方法需要传入一个参数表示购买使用的金钱，如果金钱足够则打印"xx物品被卖出"的信息，并将找零作为返回值。
 * 否则打印"金钱不足，购买失败"，并将"-1"作为返回值表示购买失败。
 * 类定义完毕后，试着创建三个对象并使用"对象名点"完成属性赋值：
 * 1. "手机类的Samsung Galaxy S21 8000元"
 * 2. "家具类的海尔冰箱 3000元"
 * 3. "日用品类的海飞丝洗发水 30元"
 * <p>
 * // 什么是类， 什么是对象。
 * // 类是创建对象的模板。对象根据类创建出来。
 * <p>
 * <p>
 * // 如果说有另外一个场景。   比如，手机有很多。  需要记录手机的  CPU  价格  重量  运行内存
 * // 在这个案例中，什么是类，什么是对象。
 * 手机是一个类。    iphone15   huaweimate60  xiaomi14
 * <p>
 * 然后自行调用一下售卖方法，测试一下。
 *
 * @author Common-zhou
 * @since 2024-03-05 10:23
 */
public class Homework2 {
    public static void main(String[] args) {
        // * 1. "手机类的Samsung Galaxy S21 8000元"
        // * 2. "家具类的海尔冰箱 3000元"
        // * 3. "日用品类的海飞丝洗发水 30元"
        Item phoneItem = new Item();
        phoneItem.type = "手机类";
        phoneItem.name = "Samsung Galaxy S21";
        phoneItem.price = 8000;

        Item furnitureItem = new Item();
        furnitureItem.type = "家具类";
        furnitureItem.name = "海尔冰箱";
        furnitureItem.price = 3000;

        Item dailyNecessitiesItem = new Item();
        dailyNecessitiesItem.type = "日用品类";
        dailyNecessitiesItem.name = "海飞丝洗发水";
        dailyNecessitiesItem.price = 30;

        int returnMoney = phoneItem.sell(8500);
        System.out.println("returnMoney = " + returnMoney);

        int returnMoney2 = furnitureItem.sell(2900);
        System.out.println("returnMoney2 = " + returnMoney2);
    }

    @Test
    public void test1(){
        // 类其实就是一个（Java）模板， 对象就是根据这个模板创建出来的一个一个的实例。
        // 类和对象，在Java中用来干什么？
        // 组合数据。
        // 比如，现在你想在代码里，模拟一个飞机。 飞机有非常多数据。 现在想存储这些数据。

        //  用类来组合数据，有什么好处。
    }
}


class Item {
    // 类里面可以定义属性。定义方法
    // [权限修饰符] 类型 成员变量名;

    public String name;
    // BigDecimal 这个事，大家先知道。 今后进入企业中，用这个类。 但是自己在日常的练习中，可以先用  int  double
    public int price;
    public String type;

    // [权限修饰符] 返回值类型 方法名(形参列表){方法体}

    //1. 售卖。该方法需要传入一个参数表示购买使用的金钱，如果金钱足够则打印"xx物品被卖出"的信息，并将找零作为返回值。
    //  * 否则打印"金钱不足，购买失败"，并将"-1"作为返回值表示购买失败。
    public int sell(int providedMoney) {
        if (providedMoney >= price) {
            // 价格足够。 卖出去了
            System.out.println(name + "物品被卖出");
            return providedMoney - price;
        } else {
            System.out.println(name + "金钱不足，购买失败");
            return -1;
        }
    }

}

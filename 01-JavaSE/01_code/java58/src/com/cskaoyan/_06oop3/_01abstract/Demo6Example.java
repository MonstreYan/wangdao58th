package com.cskaoyan._06oop3._01abstract;

/**
 * 公司正在开发一套员工管理系统，需要对公司内部存在的员工进行管理
 * 公司将员工分为三类，普通员工负责杂项工作，程序员负责技术开发，经理负责统筹规划
 * 普通员工包含3个属性：姓名、工号以及工资，行为是工作
 * 程序员包含3个属性：姓名、工号以及工资，行为是工作和加班（overtime work）
 * 经理包含4个属性：姓名、工号、工资以及奖金（bonus），行为是工作
 *
 * @author Common-zhou
 * @since 2024-03-11 17:55
 */
public class Demo6Example {
    public static void main(String[] args) {
        // 抽象类有什么用----------
        // 现在，一个方法，不想有方法体。直接去掉方法体。abstract  class上也加。
        // ===》 抽象方法、 抽象类。
        // 让子类实现。
        // =====================================
        // 光写一个方法定义，有什么好处？
        // 子类必须要实现。 减少了不匹配问题。
        // 定义一个规范。 告诉别人这里有这些方法， 方法有这些返回值。 但是具体的实现我不知道。
        // 接口： 里面全是抽象方法的结构。

        // 父类引用指向子类对象。   自动类型转换
        // BaseStaff normalStaff = new NormalStaff();
        BaseStaff normalStaff = new CoderStaff("景天", "007", 15000);
        normalStaff.work();
        normalStaff.showInfo();

        ((CoderStaff) normalStaff).overtimeWork();

    }
}

// 抽象类和普通类，区别不大。
// 抽象类中可以定义抽象方法，抽象方法没有方法体。
// 抽象类，不能实例化。
abstract class BaseStaff {
    // 姓名、工号以及工资
    String name;
    String staffId;
    int salary;

    public BaseStaff(String name, String staffId, int salary) {
        this.name = name;
        this.staffId = staffId;
        this.salary = salary;
    }

    // 不需要存在方法体。因为我们不知道如何实现这个方法。
    // 就可以使用抽象方法
    // Missing method body, or declare abstract
    public abstract void work();

    public void showInfo() {
        System.out.println(name + "===>" + staffId + "===>" + salary);
    }
}

// ======================================经常用到
// 一般情况下。 编译报错的时候，不知道怎么解决。
// 1.看一下提示。
// 2.让idea帮忙操作。   到编译报错行， alt+enter

// 普通员工包含3个属性：姓名、工号以及工资，行为是工作
class NormalStaff extends BaseStaff {

    public NormalStaff(String name, String staffId, int salary) {
        super(name, staffId, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工负责杂项工作");
    }
}

// 程序员包含3个属性：姓名、工号以及工资，行为是工作和加班（overtime work）
class CoderStaff extends BaseStaff {

    public CoderStaff(String name, String staffId, int salary) {
        super(name, staffId, salary);
    }

    @Override
    public void work() {
        System.out.println("程序员负责开发工作");
    }

    public void overtimeWork() {
        System.out.println("程序员正在加班");
    }
}


// 经理包含4个属性：姓名、工号、工资以及奖金（bonus），行为是工作
class ManagerStaff extends BaseStaff {


    int bonus;

    public ManagerStaff(String name, String staffId, int salary) {
        super(name, staffId, salary);
    }

    @Override
    public void work() {
        System.out.println("经理负责统筹工作");
    }
}

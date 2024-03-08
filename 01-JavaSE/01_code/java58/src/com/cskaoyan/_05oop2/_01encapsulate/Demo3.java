package com.cskaoyan._05oop2._01encapsulate;

/**
 * 定义一个员工Employer类,  类中有3个属性: 姓名 , 年龄 , 工资, 提供一个打印基本信息的public的方法
 * <p>
 * 练习1：
 * 对上述例子进行修改, 要求通过无参构造方法去创建对象,
 * 通过set方法对成员变量进行设置值, 要求年龄范围在1-100之间 ,
 * 工资在10K-15K范围内, 不在此范围内, 赋予默认值.
 * <p>
 * 练习2：
 * 对上述例子的基础上, 要求通过有参构造方法去创建对象,
 * 要求年龄范围在1-100之间 , 工资在10K-15K范围内, 不在此范围内, 赋予默认值.
 *
 * @author Common-zhou
 * @since 2024-03-08 14:48
 */
public class Demo3 {
    public static void main(String[] args) {
        Employer employer = new Employer();
        employer.setAge(200);
        // employer.setSalary(8000);
        employer.setSalary(12000);

        employer.showInfo();

        System.out.println("=====================================");

        Employer employer1 = new Employer(20, 8000);
        employer1.showInfo();


        System.out.println("=========================");
        Employer employer2 = new Employer("zhangsan", 30, 7000);
        employer2.showInfo();

    }
}


class Employer {
    private String name;
    private int age;
    private int salary;


    // [访问权限修饰符] 类名(){
    // }

    // 通常情况下， 构造方法不会没事去调另外的构造方法。
    // 如果逻辑很复杂，我们不想重复写代码，这时候可以调。

    public Employer() {
    }

    public Employer(int age, int salary) {
        if (age < 1 || age > 100) {
            age = 0;
        }

        if (salary < 10000 || salary > 15000) {
            salary = 0;
        }

        this.age = age;
        this.salary = salary;
    }

    public Employer(String name, int age, int salary) {

        this(age, salary);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //  要求年龄范围在1-100之间 ,
        if (age < 1 || age > 100) {
            // 不符合规范
            this.age = 0;
            return;
        }

        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        // 工资在10K-15K范围内, 不在此范围内, 赋予默认值.
        if (salary < 10000 || salary > 15000) {
            salary = 0;
        }

        this.salary = salary;
    }

    public void showInfo() {
        System.out.println("雇员名称:" + this.name + ", 年龄：" + age + ", 薪资：" + this.salary);
    }
}

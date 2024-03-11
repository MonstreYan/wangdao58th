package com.cskaoyan._05oop2._02extends._11override;

/**
 * 1.子类中重写的方法，访问权限等级，必须至少保持一致，可以更为宽松，但一定不能更严格。
 * 2.子类中重写的方法，返回值类型必须和原先父类方法的返回值类型，保持兼容。(返回相同，或者子类)
 * 3.子类中重写的方法，方法名必须严格保持一致，不能做任何修改。
 * 4.子类中重写的方法，形参列表必须保持严格一致，不能做任何修改。
 * 5.方法体的代码，无所谓，可以保持一致，也可以修改。
 *
 * @author Common-zhou
 * @since 2024-03-11 11:27
 */
public class Demo4 {

}

class Father4 {
    protected void test1() {

    }

    // 返回值类型，必须保持一致，或者保持兼容
    // 兼容：该类的子类可以
    public Father4 test2() {
        return null;
    }

    // 对于基本数据类型，父类怎么定义这个返回值。 子类就怎么定义。 不要改动
    public int test3() {
        return 0;
    }

    public static void testStaticMethod() {

    }

    public void test4() {

    }

}

class Son4 extends Father4 {

    // 'test1()' in 'com.cskaoyan._05oop2._02extends._11override.Son4' clashes with 'test1()'
    // in 'com.cskaoyan._05oop2._02extends._11override.Father4'; attempting to assign weaker
    // access privileges ('package-private'); was 'protected'
    @Override
    protected void test1() {

    }

    // 'test2()' in 'com.cskaoyan._05oop2._02extends._11override.Son4' clashes with 'test2()' in '
    // com.cskaoyan._05oop2._02extends._11override.Father4'; attempting to use incompatible return type
    @Override
    public Father4 test2() {
        return null;
    }

    @Override
    public int test3() {
        return 0;
    }

    // @Override
    // public static void testStaticMethod() {
    //
    // }


    // @Override
    // public void test4() {
    //     // super 是什么意思？ 调用父类的test4() 方法。
    //     super.test4();
    // }

    @Override
    public void test4() {
        super.test4();
    }
}

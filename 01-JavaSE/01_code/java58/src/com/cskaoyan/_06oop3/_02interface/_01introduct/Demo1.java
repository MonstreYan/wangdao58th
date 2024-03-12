package com.cskaoyan._06oop3._02interface._01introduct;

/**
 * 比如，现在需要定义一种顶级动物类，这个动物类，我们知道能行动，能觅食，能叫。
 * 但是因为太过顶级，我们不知道它怎样行动的，怎样觅食的。我们可以使用抽象类来完成，
 * 也就是三个抽象方法。我们也可以使用接口来完成。
 *
 * @author Common-zhou
 * @since 2024-03-12 10:13
 */
public class Demo1 {

}

abstract class Animal1 {
    public abstract void move();

    public abstract void eat();

    public abstract void shout();
}

// 也可以使用接口来完成。   interface.
// 语法： interface 接口名
interface Animal11 {
    // Modifier 'abstract' is redundant for interface methods
    public void move();

    public void eat();

    public void shout();
}

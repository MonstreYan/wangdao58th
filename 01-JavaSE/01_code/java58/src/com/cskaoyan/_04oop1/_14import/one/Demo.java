package com.cskaoyan._04oop1._14import.one;

import com.cskaoyan._04oop1._14import.another.Student;
import com.cskaoyan._04oop1._14import.another.Teacher;

/**
 * @author Common-zhou
 * @since 2024-03-07 17:08
 */
public class Demo {
    public static void main(String[] args) {
        // Student student = new Student();
        // // 这个Student是哪个Student。   ==》  是another 还是 one
        // 是one包。 因为我也在one下面。所以我直接用one
        // student.test();

        // 2.如果现在，想用another里面的Student。 怎么做？
        // 可以使用导包。 导包也不需要记。
        Student student = new Student();
        student.test();

        // new 的时候。选一下别的包的就可以。
        // 假设，我又想用one的咋样？  ==> 可以用全限定类名。
        com.cskaoyan._04oop1._14import.one.Student student1 = new com.cskaoyan._04oop1._14import.one.Student();

        // 不用记忆。只用让idea选就行了。但是一定要注意，写代码的时候。用的是哪个类。
        // 如果你想用一包下的，一定要注意。 看清楚。
        // 如果你发现没有你的这些方法。 检查一下，是不是正确的包。
        // 可以使用ctrl点住。 然后鼠标浮动，去看是否是正确的包。
        new Teacher();

        // Math

    }
}

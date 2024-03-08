package com.cskaoyan._05oop2._01encapsulate;

/**
 * 对于变量名  isFlag  isStudent ，is形式的变量名，使用的时候，可能会有问题。
 * 所以不要使用  isStudent  这种名字
 *
 * 在有一些框架的内部，解析可能会出问题。   ===》
 *
 * @author Common-zhou
 * @since 2024-03-08 15:47
 */
public class Demo6 {

    private boolean isStudent;

    // public boolean getIsStudent(){
    //     return isStudent;
    // }
    //

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

}

package com.cskaoyan._06oop3._03inner._03static;

/**
 * 3.外部其他类，访问静态内部类成员。
 * 首先需要有权限，需要有外部类权限。也需要有内部类权限。(private protected public )
 * 创建了对象之后，就按照普通的来访问就行了。但是也要有访问权限
 *
 * @author Common-zhou
 * @since 2024-03-13 10:10
 */
public class Demo7 {
    public static void main(String[] args) {
        // 创建外部类里面的内部类对象
        OuterClazz7.InnerClazz7 innerClazz7 = new OuterClazz7.InnerClazz7();
        String publicString = innerClazz7.publicString;
    }
}

class OuterClazz7 {
    public static class InnerClazz7 {
        private String privateString = "privateString";
        String defaultString = "defaultString";
        public String publicString = "publicString";
    }
}

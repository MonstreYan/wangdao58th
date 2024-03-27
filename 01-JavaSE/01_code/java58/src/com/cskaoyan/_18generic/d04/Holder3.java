package com.cskaoyan._18generic.d04;

/**
 * 使用泛型来是实现。
 *
 * @author Common-zhou
 * @since 2024-03-27 10:23
 */
public class Holder3<T> {
    private T data;

    public Holder3(T data) {
        this.data = data;
    }

    public T get() {
        return this.data;
    }
}

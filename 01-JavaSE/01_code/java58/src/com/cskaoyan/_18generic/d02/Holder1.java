package com.cskaoyan._18generic.d02;

/**
 * 车库1实现： 使用Object实现车库类。
 *
 * @author Common-zhou
 * @since 2024-03-27 09:59
 */
public class Holder1 {
    private Object object;

    public Holder1(Object object) {
        this.object = object;
    }

    public Object get() {
        return this.object;
    }
}

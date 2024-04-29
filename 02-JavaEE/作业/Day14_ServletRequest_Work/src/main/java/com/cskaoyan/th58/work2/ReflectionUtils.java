package com.cskaoyan.th58.work2;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 10:00
 * @Version 1.0
 */
public class ReflectionUtils {

    private static final String SET_PREFIX = "set";
    //借助于反射；对象o里面有对应的属性，成员变量
    //params：请求参数的键值对；如果请求参数的key值和对象里面的属性值相同，则仅赋值操作
    //可以使用set方法来进行赋值；也可以使用属性直接进行赋值操作
    public static void toBean(Object o, Map<String, String[]> params) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = o.getClass();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            String[] value = params.get(key);
            //使用当前成员变量的类型来充当方法的形参类型
            Field field = aClass.getDeclaredField(key);
            Class<?> type = field.getType();
            Method method = aClass.getMethod(SET_PREFIX + StringUtils.capitalize(key), type);
            if(type.getSimpleName().equals("String")){
                method.invoke(o, value[0]);
            }else if(type.getSimpleName().equals("String[]")){
                method.invoke(o, (Object) value);
            }
        }
    }
}

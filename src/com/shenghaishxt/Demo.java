package com.shenghaishxt;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Demo {
    private List<Integer> list1;

    public static void getFieldGenericType() {
        try {
            Field field = Demo.class.getDeclaredField("list1");
            Type type = field.getGenericType();
            ParameterizedType pt = (ParameterizedType) type; //取得field的type
            Type[] genericTypes = pt.getActualTypeArguments(); //强转成具体的实现类
            System.out.println(genericTypes[0]); //取得包含的泛型类型
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getFieldGenericType();
    }
}

package com.dust.ms.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类型擦除，不能用泛型作方法重载
 * 2. 不支持泛型数组
 *
 */
public class TestGeneric {
    private static <T> T test(T t) {
        return t;
    }

    public void listMethod(List<Integer> intList) {
    }

    public static void main(String[] args) {
        String str = "Hello";
        String rst = test(str);

        ArrayList<String> strList = new ArrayList<>();


    }
}

class Cart<T> {
    T[] arr;

}

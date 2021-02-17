package com.demo.function;

import java.util.function.Function;

/**
 * Function函数式接口，有一个输入参数，有一个输出
 */
public class Demo01 {
    public static void main(String[] args) {
        // 方法1
//        Function<String,String> function = new Function<String,String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
        // 方法2
//        Function<String,String> function = (s) -> { return s; };

        // 方法3
//        Function<String,String> function = s -> s;

        // 输出结果
//        System.out.println(function.apply("Hello World"));
    }
}

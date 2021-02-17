package com.demo.function;

import java.util.function.Predicate;

public class Demo02 {
    public static void main(String[] args) {

        // 方法1
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        // 方法2
//        Predicate<String> predicate = s -> {
//            return s.isEmpty();
//        };

        // 方法3
//        Predicate<String> predicate = String::isEmpty;
//        System.out.println(predicate.test("Hello World"));
    }
}

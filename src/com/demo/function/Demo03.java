package com.demo.function;

/**
 * Consumer 消费型接口 只有输入 没有输出
 */
public class Demo03 {
    public static void main(String[] args) {
        // 方法1
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        // 方法2
//        Consumer<String> consumer = s -> System.out.println(s);

        // 方法3
//        Consumer<String> consumer = System.out::println;

        // consumer.accept("Hello World");
    }
}

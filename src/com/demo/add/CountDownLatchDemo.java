package com.demo.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        final int length = 5;
        // 减法器
        CountDownLatch countDownLatch = new CountDownLatch(length);
        for (int i = 0; i < length; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(temp);
                // 减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            // 等待计数器归零，才向下执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");


    }
}

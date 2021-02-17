package com.demo.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用 : Ajax
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的 runAsync 异步回调
//        // 发起一个请求
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " runAsync=>Void");
//        });
//        // 获取阻塞执行结果
//        completableFuture.get();

        // 有返回值的 supplyAsync 异步回调
        // ajax 有成功和失败的回调
        // 返回错误信息
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "supplyAsync");
//            return 1024;
//        });
//        System.out.println(completableFuture.whenComplete((u, t) -> {
//            System.out.println("t=>" + t);  // 正确的返回结果
//            System.out.println("u=>" + u);  // 错误的返回结果
//        }).exceptionally((e) -> {
//            System.out.println(e.getMessage());
//            return -1; // 可以获取到错误的返回结果
//        }).get());


    }
}

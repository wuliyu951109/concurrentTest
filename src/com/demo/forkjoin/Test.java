package com.demo.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

// 薪水:3000  6000(ForkJoin)  9000(Stream并行流)
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
        test3();
    }

    // 4315毫秒
    public static void test1() {
        long start = System.currentTimeMillis();

        Long sum = 0L;
        for (long i = 0; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("for循环 : \tsum=" + sum + " 时间: " + (end - start) + "毫秒");
    }

    // 6538毫秒
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();

        long end = System.currentTimeMillis();

        System.out.println("forkjoin : \tsum=" + sum + " 时间: " + (end - start) + "毫秒");
    }

    // 502毫秒
    public static void test3() {
        long start = System.currentTimeMillis();

        // Stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();

        System.out.println("Stream并行 : sum=" + sum + " 时间: " + (end - start) + "毫秒");
    }

}

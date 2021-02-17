package com.demo.forkjoin;


import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务
 * // 如何使用forkjoin
 * // 1.ForkJoinPool 通过它来执行
 * // 2.计算任务 ForkJoinPool.execute(ForkJoinTask task)
 * // 3.计算类要继承ForkJoinTask
 * // ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;         // 0
    private Long end;           // 10_0000_0000

    // 临界值
    private Long temp = 1000_0000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if (end-start < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else { // forkjoin
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}

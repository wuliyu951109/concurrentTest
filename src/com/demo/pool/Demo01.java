package com.demo.pool;

import java.util.concurrent.*;

// Executors 工具类, 3大方法, 7大参数, 4大拒绝策略

/**
 *
 *     public ThreadPoolExecutor(int corePoolSize,   // 核心线程池大小
 *                               int maximumPoolSize,// 最大线程池大小
 *                               long keepAliveTime, // 保持连接的时间，超时没有人调用就会释放
 *                               TimeUnit unit,      // 超时单位
 *                               BlockingQueue<Runnable> workQueue, // 线程的阻塞队列
 *                               ThreadFactory threadFactory,       // 线程工厂，创建线程的，一般不用动
 *                               RejectedExecutionHandler handler)  // 拒绝策略
 *  new ThreadPoolExecutor.AbortPolicy()        // 银行满了 还有人进来 不处理这个人的 抛出异常
 *  new ThreadPoolExecutor.CallerRunsPolicy()   // 哪来的去哪里
 *  new ThreadPoolExecutor.DiscardOldestPolicy()// 队列满了 丢掉任务 不会抛出异常
 *  new ThreadPoolExecutor.DiscardPolicy()      // 队列满了 尝试去和最早的竞争 也不会抛出异常
 */
public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);     // 创建一个固定的线程池大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();     // 可伸缩的 遇强则强 遇弱则弱

        // 4核
//        System.out.println(Runtime.getRuntime().availableProcessors());

        // 自定义线程池

        /**
         * 最大线程到底该如何定义
         * 1.CPU密集型 几核CPU就用几个线程 可以保持CPU的效率最高
         * 2.IO 密集型 > 判断程序中十分消耗IO的线程数
         */
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 0; i < 10; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            threadPool.shutdown();
        }
    }
}

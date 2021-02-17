package com.demo.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 抛出异常
     * add()
     * remove()
     */
    public static void test1() {
        // 队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        // 添加元素
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // IllegalStateException : Queue full 队列已满
        // System.out.println(blockingQueue.add("d"));

        // 分割线
        System.out.println("========================");

        // 队首元素
        System.out.println("队首元素：");
        System.out.println(blockingQueue.element());

        // 分割线
        System.out.println("========================");

        // 删除元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // NoSuchElementException 没有这个元素
        // System.out.println(blockingQueue.remove());
    }

    /**
     * 不抛出异常 返回null或者false
     */
    public static void test2() {
        // 队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        // 添加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 添加元素失败 返回false 不抛出异常
        // System.out.println(blockingQueue.offer("d"));

        // 分割线
        System.out.println("========================");

        // 队首元素
        System.out.println(blockingQueue.peek());

        // 分割线
        System.out.println("========================");

        // 删除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //删除元素失败 返回null 不抛出异常
        // System.out.println(blockingQueue.poll());

    }

    /**
     * 等待 阻塞 (一直阻塞)
     */
    public static void test3() throws InterruptedException {
        // 队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        // 添加元素
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 队列没有位置，阻塞等待
        // blockingQueue.put("d");

        // 分割线
        System.out.println("========================");

        // 删除元素
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 队列空，阻塞等待
        // System.out.println(blockingQueue.take());
    }

    /**
     * 等待 阻塞 (等待 超时)
     */
    public static void test4() throws InterruptedException {
        // 队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        // 添加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 添加元素失败 等待2秒 返回false 不抛出异常
        System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));

        // 分割线
        System.out.println("========================");

        // 删除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 删除元素失败 等待2秒 返回null 不抛出异常
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }
}


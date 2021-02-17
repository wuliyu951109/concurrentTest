package com.demo.tvolatile;

/**
 * volatile：
 * 1.保证可见性
 * 2.不保证原子性
 * 3.防止指令重排
 */
public class VDemo02 {
    private volatile static int num = 0;
    public static synchronized void add() {
        num ++;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}

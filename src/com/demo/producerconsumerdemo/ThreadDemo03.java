package com.demo.producerconsumerdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo03 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.decrement();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.increment();
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

class Data2 {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
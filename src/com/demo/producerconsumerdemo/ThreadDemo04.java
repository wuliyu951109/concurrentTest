package com.demo.producerconsumerdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo04 {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.printA();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.printB();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.printC();
            }
        }, "C").start();
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    public void printA() {
        lock.lock();
        try {
            while (number!=1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAAAA");
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number!=2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBBBBB");
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number!=3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCCCCC");
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
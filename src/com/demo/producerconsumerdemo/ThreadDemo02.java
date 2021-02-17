package com.demo.producerconsumerdemo;
public class ThreadDemo02 {
    public static void main(String[] args) {
        Data1 data = new Data1();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Data1 {
    private int number = 0;
    public synchronized void increment() throws InterruptedException {
        // 用while防止虚假唤醒问题
        while (number != 0) {
            this.wait();
        }
        number ++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        // 用while防止虚假唤醒问题
        while (number != 1) {
            this.wait();
        }
        number --;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }
}

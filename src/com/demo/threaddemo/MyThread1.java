package com.demo.threaddemo;

public class MyThread1 extends Thread {
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        myThread1.start();
        myThread2.start();
    }
}

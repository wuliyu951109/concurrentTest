package com.demo.threaddemo;

public class MyThread2 implements Runnable {

    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}  
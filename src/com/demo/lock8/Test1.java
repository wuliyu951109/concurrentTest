package com.demo.lock8;

import java.util.concurrent.TimeUnit;
// 1:发短信  2:打电话
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{phone.sendSms();}, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone.call();}, "B").start();
    }
}

class Phone {
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call() {
        System.out.println("打电话");
    }
}
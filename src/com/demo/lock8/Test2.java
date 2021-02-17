package com.demo.lock8;

import java.util.concurrent.TimeUnit;

// 1:发短信  2:打电话
public class Test2 {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        Phone1 phone2 = new Phone1();
        new Thread(phone1::sendSms, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(phone2::call, "B").start();
    }
}

class Phone1 {
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


    // 没有锁 非同步方法 不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}
package com.demo.lock8;

import java.util.concurrent.TimeUnit;

// 1:发短信  2:打电话
public class Test3 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，锁的是class
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(()->{phone1.sendSms();}, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        }, "B").start();
    }
}

// 锁的是class对象 静态synchronized方法
class Phone2 {
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call() {
        System.out.println("打电话");
    }

}
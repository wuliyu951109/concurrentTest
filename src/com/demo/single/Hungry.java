package com.demo.single;

// 饿汉式单例
public class Hungry {

    private Hungry() {}

    public final static Hungry getHungry() {
        return HUNGRY;
    }

    public final static Hungry HUNGRY = new Hungry();

}

package com.demo.single;

// enum也是一个Class类
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) {
        EnumSingle enumSingle1 = EnumSingle.INSTANCE;
        EnumSingle enumSingle2 = EnumSingle.INSTANCE;
        System.out.println(enumSingle1);
        System.out.println(enumSingle2);
    }
}
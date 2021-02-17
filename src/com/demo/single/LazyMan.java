package com.demo.single;

// 懒汉式
public class LazyMan {

    private LazyMan() {}

    private static LazyMan lazyMan;

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(LazyMan.getInstance());
            }).start();
        }
    }

}

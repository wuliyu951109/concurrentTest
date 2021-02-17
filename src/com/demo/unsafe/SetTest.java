package com.demo.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {
        /**
         * 解决方案
         * 1.Set<String> set = new HashSet<>();
         * 2.Set<String> set = Collections.synchronizedSet(new HashSet<>());
         * 3.Set<String> set = new CopyOnWriteArraySet<>();
         * CopyOnWrite写入时复制 COW 计算机程序设计领域的一种优化策略
         * 多个线程调用的时候，set在写入时是固定的，写入(覆盖)
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         */
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 15; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}

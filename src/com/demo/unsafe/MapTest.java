package com.demo.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        /**
         * 解决方案
         * 1.Map<String, String> map = new HashMap<>();
         * 2.Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
         * 3.Map<String, String> map = new ConcurrentHashMap<>();
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         */
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 15; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}

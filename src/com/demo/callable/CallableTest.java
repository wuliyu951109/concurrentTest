package com.demo.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            return 1+1*24;
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

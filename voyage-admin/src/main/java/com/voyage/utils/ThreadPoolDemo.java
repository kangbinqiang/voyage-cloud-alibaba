package com.voyage.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//线程池为5
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//N个处理线程
        //ThreadPoolExecutor

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

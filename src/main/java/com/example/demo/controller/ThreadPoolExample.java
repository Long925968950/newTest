package com.example.demo.controller;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,  // 核心线程数
                4,  // 最大线程数
                60L, // 空闲线程的存活时间
                TimeUnit.SECONDS, // 存活时间的单位
                new LinkedBlockingQueue<>(10) // 任务队列
        );

        // 提交任务给线程池
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }

        // 关闭线程池
        executor.shutdown();
    }

    // 定义一个简单的任务类
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is executing task.");
            try {
                Thread.sleep(1000); // 模拟任务执行时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}



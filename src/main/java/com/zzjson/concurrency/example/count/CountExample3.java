package com.zzjson.concurrency.example.count;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2018 rollBall team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : com.zzjson.concurrency.example.count</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月05日</li>
 * <li>@author     : zzy0_0</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Slf4j
public class CountExample3 {
    //并发总数
    public static int clientTotal = 5000;
    //同时并发的数
    public static int count = 50;

    public static void main(String[] args) throws InterruptedException {
        //获取线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        Semaphore semaphore = new Semaphore(count);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
                semaphore.release();
            });
        }
        countDownLatch.await();
        countDownLatch.countDown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }
}
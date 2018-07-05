package com.zzjson.concurrency;

import com.zzjson.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2018 rollBall team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : com.zzjson.concurrency</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月05日</li>
 * <li>@author     : zzy0_0</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    //并发总数
    public static int clinetTotal = 1000;

    // 同时并发执行的线程数
    public static int threadTotal = 50;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //线程池
        final ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
        for (int i = 0; i < clinetTotal; i++) {
            executorService.execute(() -> {
                //执行
                try {
                    //信号量执行,其实就是判断是否允许执行，不行的话就阻塞掉
                    semaphore.acquire();
                    add();
                    //释放
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                //闭锁
                //执行一个减少一个clinetTotal
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }
}
package com.zzjson.concurrency.example.Singleton;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2018 rollBall team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : com.zzjson.concurrency.example.Singleton</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月11日</li>
 * <li>@author     : zzy0_0</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
//懒汉式

public class SingletonExample {

    public volatile static SingletonExample singletonExample;

    //1. 禁止重排序
    //2. 内存屏障
    private SingletonExample() {
    }

    public static SingletonExample getSingletonExample() {

        if (singletonExample == null) {
            synchronized (SingletonExample.class) {
                singletonExample = new SingletonExample();
            }
        }
        return singletonExample;
    }
}



// 主内存->  工作内存--》jvm
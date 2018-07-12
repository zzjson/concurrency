package com.zzjson.concurrency.example.Singleton;

import com.zzjson.concurrency.annoations.NotRecommend;
import com.zzjson.concurrency.annoations.NotThreadSafe;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2018 rollBall team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : 懒汉式/li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月11日</li>
 * <li>@author     : zzy0_0</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample2 {
    public static SingletonExample2 singletonExample2 = null;

    private SingletonExample2() {

    }

    private static synchronized SingletonExample2 getInstance() {
        if (singletonExample2 == null) {
            singletonExample2 = new SingletonExample2();
        }
        return singletonExample2;
    }

    public static void main(String[] args) {
        SingletonExample2.getInstance();
    }
}
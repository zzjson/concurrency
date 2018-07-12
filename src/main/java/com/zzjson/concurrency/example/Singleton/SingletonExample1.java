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
public class SingletonExample1 {
    public static SingletonExample1 singletonExample1 = null;

    private SingletonExample1() {

    }

    private synchronized SingletonExample1 getInstance() {
        if (singletonExample1 == null) {
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }

}
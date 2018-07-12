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
public class SingletonExample4 {
    public static SingletonExample4 singletonExample4 = new SingletonExample4();

    private SingletonExample4() {

    }

    private static synchronized SingletonExample4 getInstance() {
        return singletonExample4;
    }

    enum SingleTonEnum {
        instance;
        private SingletonExample4 singletonExample4;
        //构造 -》 jvm保证线程
        SingleTonEnum() {
            singletonExample4 = new SingletonExample4();
        }

        public SingletonExample4 getSingletonExample4() {
            return singletonExample4;
        }
    }

    public static void main(String[] args) {
        SingletonExample4 singletonExample4 = SingleTonEnum.instance.getSingletonExample4();
    }
}

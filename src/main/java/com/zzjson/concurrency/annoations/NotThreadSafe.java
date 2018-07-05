package com.zzjson.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2018 rollBall team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : 用来标记线程不安全的写法</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月05日</li>
 * <li>@author     : zzy0_0</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
    String value() default "";
}
package com.zzjson.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
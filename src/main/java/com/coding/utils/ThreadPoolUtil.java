package com.coding.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengKai
 * @date: 2022/05/24 21:55
 * @description: thread pool utils
 */
public class ThreadPoolUtil {
    
    private ThreadPoolUtil() {}

    private static final ExecutorService POOL = new ThreadPoolExecutor(10, 1024, 2000L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024));

    public static void submit(Runnable runnable) {
        POOL.submit(runnable);
    }
}

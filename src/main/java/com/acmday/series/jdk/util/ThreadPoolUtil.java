package com.acmday.series.jdk.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author acmday.
 * @date 2020/4/4.
 */
public class ThreadPoolUtil {

    //public static LinkedBlockingQueue workQueue=new LinkedBlockingQueue<Runnable>(500);

    public static final ExecutorService executor = new ThreadPoolExecutor(5, 5, 20L,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(5),
            new ThreadFactoryBuilder().setNameFormat("thread_%d").build(),
            new CustomRejectedExecutionHandler()
    );

    /**
     * 线程池队列满后的拒绝策略
     */
    private static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) {
                r.run();
            }
            System.out.println( "act=EverestThreadUtil.rejectedExecution desc=ThreadPool LinkedBlockingQueue is full！！！ executorActiveCount=" + executor.getActiveCount()
                            +" Task " + r.toString() + " rejected from " + executor.toString());
        }
    }
}
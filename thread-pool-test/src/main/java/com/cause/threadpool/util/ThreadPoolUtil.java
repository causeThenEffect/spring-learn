package com.cause.threadpool.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {
    private static final Logger log = LoggerFactory.getLogger(ThreadPoolUtil.class);

    public static ThreadPoolExecutor createThreadPoolForIOIntensiveJob(Integer poolSize, String name){
        return new ThreadPoolExecutor(
                poolSize,
                poolSize,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1),
                new ThreadFactoryBuilder().setNameFormat(name + "-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public static ThreadPoolExecutor createThreadPoolForIORequest(Integer poolSize, String name) {
        return new ThreadPoolExecutor(
                poolSize,
                poolSize * 50,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadFactoryBuilder().setNameFormat(name + "-%d").build(),
                new ThreadPoolExecutor.DiscardPolicy() {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        log.error("discard Runnable:{}, ThreadPoolExecutor:{}", r, e);
                    }
                }
        );
    }

    public static void logExecutor(ThreadPoolTaskExecutor threadPoolExecutor, String threadPoolName) {
        // 线程池需要执行的任务数
//        final long taskCount = threadPoolExecutor.getTaskCount();

        // 线程池在运行过程中已完成的任务数
//        final long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();

        // 曾经创建过的最大线程数
//        final int largestPoolSize = threadPoolExecutor.getLargestPoolSize();

        // 线程池里的线程数量
        final int poolSize = threadPoolExecutor.getPoolSize();

        // 线程池里活跃的线程数量
        final int activeCount = threadPoolExecutor.getActiveCount();

        // 配置的核心线程数
        final int corePoolSize = threadPoolExecutor.getCorePoolSize();

        // 配置的最大线程数
//        final int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();

        // 当前线程池队列的个数
//        final int queueSize = threadPoolExecutor.getQueue().size();

        log.info("ThreadPool {} monitor, activeCount:{}, poolSize:{}, largestPoolSize:{}, queueSize:{}, taskCount:{}, completedTaskCount:{}, corePoolSize:{}, maximumPoolSize:{}", threadPoolName, activeCount, poolSize, 0, 0, 0,0, corePoolSize, 0);
    }
}

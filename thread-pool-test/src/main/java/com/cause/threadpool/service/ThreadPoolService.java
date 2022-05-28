package com.cause.threadpool.service;

import com.cause.threadpool.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 */
@Service
@Slf4j
public class ThreadPoolService {

    @Resource(name = "threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolExecutor;

    @Resource(name = "executor2")
    private ThreadPoolExecutor executor3;

    public void test1() {
        ThreadPoolUtil.logExecutor(threadPoolExecutor, this.getClass().getSimpleName());
        CompletableFuture.runAsync(() -> log.info("werwe"), threadPoolExecutor);
    }

    public void test2() {
        for (int i = 0; i < 20000; i++) {
            CompletableFuture.runAsync(() -> {
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                log.info(12312 + "");
            }, executor3);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

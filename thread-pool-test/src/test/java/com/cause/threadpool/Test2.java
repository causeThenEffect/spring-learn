package com.cause.threadpool;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Slf4j
public class Test2 {

    public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(100);
        executorService.setMaxPoolSize(100);
        executorService.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ListenableFuture<Boolean> asyncResult = executorService.submitListenable(() -> {

                // 休息5毫秒，模拟执行
                TimeUnit.MILLISECONDS.sleep(5);
                //throw new RuntimeException("出现异常");
                return true;

            });
            asyncResult.addCallback(data -> {
                try {
                    // 休息3毫秒模拟获取到执行结果后的操作
                    TimeUnit.MILLISECONDS.sleep(3);
                    System.out.println(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, ex -> log.info("**异常信息**：{}", ex));
        }
        System.out.println(String.format("总结耗时：%s", System.currentTimeMillis() - start));


        /**
         *
         */
        ArrayList<Object> list = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        ArrayList<Boolean> integers2 = new ArrayList<>();
        list.stream().forEach(i -> {
            Future<Boolean> future = executorService.submit(() -> {

                // 休息5毫秒，模拟执行
                TimeUnit.MILLISECONDS.sleep(5);
                //throw new RuntimeException("出现异常");
                return true;

            });
            try {
                // 以阻塞的方式获取执行结果
                Boolean result = future.get();
                // logger.info(String.format("执行结果：%s", result));
                // 休息3毫秒模拟获取到执行结果后的操作
                TimeUnit.MILLISECONDS.sleep(3);
                integers2.add(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(integers2);
    }

    /*public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(1);
        executorService.setMaxPoolSize(1);
        executorService.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Future<Boolean> future = executorService.submit(() -> {
                try {
                    // 休息5毫秒，模拟执行
                    TimeUnit.MILLISECONDS.sleep(5);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });

            try {
                // 以阻塞的方式获取执行结果
                Boolean result = future.get();
                // logger.info(String.format("执行结果：%s", result));
                // 休息3毫秒模拟获取到执行结果后的操作
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(String.format("总结耗时：%s", System.currentTimeMillis() - start));
    }*/

}

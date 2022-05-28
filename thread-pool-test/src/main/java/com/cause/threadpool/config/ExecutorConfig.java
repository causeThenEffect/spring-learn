package com.cause.threadpool.config;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class ExecutorConfig {

	private static final int THREAD_NUM = Runtime.getRuntime().availableProcessors();

	@Bean("threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 设置核心线程数
		executor.setCorePoolSize(20);
		// 设置最大线程数
		executor.setMaxPoolSize(20);
		// 设置队列容量
		executor.setQueueCapacity(Integer.MAX_VALUE);
		// 设置线程活跃时间（秒）
		executor.setKeepAliveSeconds(60);
		// 设置默认线程名称
		executor.setThreadNamePrefix("testExecutor-");
		// 设置拒绝策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 等待所有任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}

	@Bean("executor2")
	public ThreadPoolExecutor executor333() {
		return new ThreadPoolExecutor(
				1,
				1 * 5,
				60L,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(10),
				new ThreadFactoryBuilder().setNameFormat("testExecutor-%d").build(),
				new ThreadPoolExecutor.DiscardPolicy(){
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
						System.out.println(THREAD_NUM + "=====>" + e.toString());
					}
				});
	}

}

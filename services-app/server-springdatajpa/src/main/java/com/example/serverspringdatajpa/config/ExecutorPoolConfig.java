package com.example.serverspringdatajpa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: cowwa
 * @Date: 2019/12/9 10:57
 * @Description: 线程池设置
 */
@Configuration
@EnableAsync
public class ExecutorPoolConfig {
    private final  static Logger logger= LoggerFactory.getLogger(ExecutorPoolConfig.class);

    @Value("${thread.pool.core-size}")
    private int coreSize;

    @Value("${thread.pool.max-size}")
    private int maxSize;

    @Value("${thread.pool.queue-capacity}")
    private int queueCapacity;

    @Value("${thread.pool.keep-alive-seconds}")
    private int keepAliveSeconds;

    @Value("${thread.pool.name-prefix}")
    private String namePrefix;

    @Bean
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new InspectThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(coreSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //空闲线程的存活时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}

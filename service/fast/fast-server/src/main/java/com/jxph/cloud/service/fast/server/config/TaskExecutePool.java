package com.jxph.cloud.service.fast.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author 谢秋豪
 * @date 2018/9/3 0:22
 */
@Configuration
public class TaskExecutePool {
    @Bean(name="myTaskExecutePool")
    public Executor taskExecutePool(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(40);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setQueueCapacity(50);
        return threadPoolTaskExecutor;
    }
}

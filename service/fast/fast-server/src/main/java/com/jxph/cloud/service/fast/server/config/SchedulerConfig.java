package com.jxph.cloud.service.fast.server.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


/**
 * @author 谢秋豪
 * @date 2018/9/1 0:36
 */
@Configuration
@ConfigurationProperties(prefix = "spring.scheduler")
@Data
@EnableScheduling
public class SchedulerConfig {
    private int poolSize;
    private String threadNamePrefix;
    private int awaitTerminationSeconds;
    private boolean waitForTasksToCompleteOnShutdown;

    @Bean(destroyMethod = "shutdown")

    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(100);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}

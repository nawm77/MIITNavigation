package com.example.miitnavigation.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Log4j2
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        executor.setRejectedExecutionHandler((r, exec) -> {
            try {
                exec.getQueue().put(r);
            } catch (InterruptedException e) {
                log.error("AsyncExecutor: Interrupted while adding a new task to the queue", e);
                Thread.currentThread().interrupt();
            }
        });

        return executor;
    }
}

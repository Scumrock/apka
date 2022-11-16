package ru.tversu.apka.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import ru.tversu.apka.handler.ExceptionHandlingAsyncTaskExecutor;

@EnableAsync
@EnableScheduling
@Configuration
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer, SchedulingConfigurer {

  private final TaskExecutionProperties taskExecutionProperties;
  private final TaskSchedulingProperties taskSchedulingProperties;

  @Autowired
  public AsyncConfiguration(TaskExecutionProperties taskExecutionProperties,
                            TaskSchedulingProperties taskSchedulingProperties) {
    this.taskExecutionProperties = taskExecutionProperties;
    this.taskSchedulingProperties = taskSchedulingProperties;
  }

  @Override
  @Primary
  @Bean(name = "taskExecutor")
  public TaskExecutor getAsyncExecutor() {
    log.debug("Creating Async Task Executor");
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(taskExecutionProperties.getPool().getCoreSize());
    executor.setMaxPoolSize(taskExecutionProperties.getPool().getMaxSize());
    executor.setQueueCapacity(taskExecutionProperties.getPool().getQueueCapacity());
    executor.setThreadNamePrefix(taskExecutionProperties.getThreadNamePrefix());
    return new ExceptionHandlingAsyncTaskExecutor(executor);
  }

  @Bean
  public TaskScheduler taskScheduler() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setThreadNamePrefix(taskSchedulingProperties.getThreadNamePrefix());
    scheduler.setPoolSize(taskSchedulingProperties.getPool().getSize());
    return scheduler;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(taskScheduler());
  }

}

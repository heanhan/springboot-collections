package com.example.taskjobs.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


/**
 * 使用SpringBoot配置定时任务的过程中,使用@Scheduled配置了多个定时任务,
 * 但是在项目启动的时候每次只会启动一个定时任务,
 * ThreadPoolTaskScheduler的源码,才发现默认开启的线程数是 1 ,
 * 每次只能执行一个定时任务,以下是部分源码
 *
 * public class ThreadPoolTaskScheduler extends ExecutorConfigurationSupport implements AsyncListenableTaskExecutor, SchedulingTaskExecutor, TaskScheduler {
 *     private volatile int poolSize = 1;
 *
 *     public void setPoolSize(int poolSize) {
 *         Assert.isTrue(poolSize > 0, "'poolSize' must be 1 or higher");
 *         this.poolSize = poolSize;
 *         if (this.scheduledExecutor instanceof ScheduledThreadPoolExecutor) {
 *             ((ScheduledThreadPoolExecutor)this.scheduledExecutor).setCorePoolSize(poolSize);
 *         }
 *
 *     }
 * }
 *
 */
@Configuration
public class TaskScheduleConfig {

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);//ThreadPoolTaskScheduler 默认开始线程数1 修改为 自定的线程数
        return taskScheduler;
    }
}

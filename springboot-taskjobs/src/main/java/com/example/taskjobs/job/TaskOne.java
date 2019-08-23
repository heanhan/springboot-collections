package com.example.taskjobs.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务 1
 */
@Component
@Slf4j
public class TaskOne {


    /**
     * fixedRate：定义一个按一定频率执行的定时任务
     * fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。
     * cron：通过表达式来配置任务执行时间--在线cron表达式生成器
     */


    /**
     * 开启定时任务 1(同步方式)
     * 同一任务的同步执行(下次任务执行将在本次任务执行完毕后的下一次配置时间开始)
     */
    @Scheduled(cron = "*/30 * * * * ?")
    public void taskJobsOne() throws InterruptedException{
        for (int i=0;i<=10;i++){
            log.info("同步定时任务开始执行。。。");
            log.info("打印:同步执行结果-->："+i);
            Thread.sleep(5000);
        }
    }

    /**
     * 同一个任务的异步定时任务
     * 1、使用注解 @Async 开启异步
     * 2、使用注解 @Scheduled 开启定时任务
     * @throws InterruptedException
     */
    @Async
    @Scheduled(cron="*/30 * * * * ?")
    public void taskJobTwo() throws InterruptedException {
        for(int i=0;i<=10;i++){
            log.info("异步定时任务的开始。。。");
            log.info("打印:异步执行结果-->"+i);
            Thread.sleep(3000);
        }
    }
}

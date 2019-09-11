package com.example.taskjobs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author : zhaojh
 * @date : 2019-09-11
 * @function :动态定时任务  方式一 ： 实现SchedulingConfigurer接口，重写
 */

@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Autowired
    private TaskScheduler taskScheduler;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler);
        //实现动态调整定时任务执行频率
        taskRegistrar.addTriggerTask(
                //1.添加任务内容
                ()-> System.out.println("aaaaaaaa----->"+Thread.currentThread().getId()),
                //设置执行周期（Trigger）
                triggerContext -> {
                    //2.1 从数据库中动态执行周期
                    String cron = "0/2 * * * * ? ";
                    //2.2 合法性校验
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );

    }
}

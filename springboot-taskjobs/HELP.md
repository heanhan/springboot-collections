# 定时任务

### 使用spring 自带的定时任务
For further reference, please consider the following sections:

定时任务的实现方式有很多种：

    1、使用spring自带的Schedule
    2、quartz
    3、
    
本章节主要介绍使用springboot 自带的定时任务，基于注解形式。

    1、在默认设置下，为什么springboot每次只启动一个定时任务。
    
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
    2、使用springboot 的实现的具体方式。
        * 在启动类上添加一个注解@EnableSchedule(其实也可以添加在定时任务的配置类上，标识开启定时任务。)
        * 在需要配执行的的方法上添加注解，实现对一个方法的定时任务。@Schedule.
            补充：如果该方法需要异步执行，只需要添加 一个注解  @Async
            
    3、关于定时任务的方法内配置的属性
        * 可以使用cron 表达式，一个cron至少有6个（也有可能为7个）有空格分割的时间元素。
            依此为：
             秒（0~59）
             分钟（0~59）
             小时（0~23）
             天（月）（0~31，但是你需要考虑到你月的天数）
             月（0~11）
             天（星期）（1~7 1=SUN或者SUN,MON,TUE,WED,THU,RFI,SAT）
             年份（1970-2099）
             
             其中每个元素可以是一个值（如6），一个连续区间（9-12），一个间隔时间（8-18/4） 【注：/ 表示每隔4小时】，一个列表（1，3，5）
             逗号 “，” 表示通配符。由于月份中的日期和星期中的日期这两个元素互斥，必须要对其中一个设置 ？
             
             示例：
                0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
                0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
                0 0 12 ? * WED 表示每个星期三中午12点 
                "0 0 12 * * ?" 每天中午12点触发 
                "0 15 10 ? * *" 每天上午10:15触发 
                "0 15 10 * * ?" 每天上午10:15触发 
                "0 15 10 * * ? *" 每天上午10:15触发 
                "0 15 10 * * ? 2005" 2005年的每天上午10:15触发 
                "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 
                "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 
                "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
                "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 
                "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发 
                "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发 
                "0 15 10 15 * ?" 每月15日上午10:15触发 
                "0 15 10 L * ?" 每月最后一日的上午10:15触发 
                "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 
                "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发 
                "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发 
                
                “*”字符代表所有可能的值
                
                因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天
                
                 
                
                “/”字符用来指定数值的增量
                
                例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
                
                         在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
                
                
                “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
                
                当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
                
                 
                
                “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
                
                但是它在两个子表达式里的含义是不同的。
                
                在天（月）子表达式中，“L”表示一个月的最后一天
                
                在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT
                
                如果在“L”前有具体的内容，它就具有其他的含义了
                
                例如：“6L”表示这个月的倒数第６天，“ＦＲＩＬ”表示这个月的最一个星期五
                
                注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题
                
                
        * 使用      



借鉴大神的笔记内容：
        
        java开发领域的，目前可以通过以下几种方式实现定时任务。
        
        1、单机部署的模式
        
        a. Timer jdk 中自带一个定时任务调度类。可以简单的实现某一频度的任务执行。提供的功能比较单一,无法实现复杂的调度任务。
        b. ScheduledExcutorService :也是jdk自带的基于线程池设计的定时任务。其每个调度任务都会分配到线程池中的一个线程执行。
        所以其任务是并发执行。互不影响。
        c. spring Task :是spring提供的一个任务调度任务。支持注解和配置，支持Cron表达式，使用简单，功能强大。
        d. Quartz 是一款功能强大的任务调度任务框架。可以实现较为复杂的调度任务。还支持分布式任务调度。
        
        
       2、分布式集群模式（不多介绍，简单提一下）
       问题：
       I、如何解决定时任务的多次执行？
       II、如何解决任务的单点问题，实现任务的故障转移？
        
        问题I的简单思考：
        1、固定执行定时任务的机器（可以有效避免多次执行的情况 ，缺点就是单点故障问题）。
        2、借助Redis的过期机制和分布式锁。
        3、借助mysql的锁机制等。
        
        
        使用spring 的spring Task 实现定时任务（springboot ）
        1、简单的定时任务实现
        实现方式：
            A:使用EnableScheduling 注解开启定时任务的支持。
            B:使用@Scheduled 注解即可，基于cron 、fixedrate、fixedDelay等一些策略实现定时任务。
            
            使用缺点：
            A: 多个定时任务使用的同一个调度线程，所以任务是阻塞执行的，执行效率不高。
            B: 其次如果出现任务阻塞，导致一些场景的定时任务没有实际意义，比如每天12点的一个计算任务，被阻塞到1点执行，会导致结果并非我们想要。
            
            使用有点：
            A : 配置简单。
            B ：适用于单个后台线程执行周期任务，并且保证顺序执行。
   
   
   
   
   
   三、动态定时任务的实现
   
        问题：
        使用@Scheduled注解来完成设置定时任务，但是有时候我们往往需要对周期性的时间的设置会做一些改变，或者要动态的启停一个定时任务，那么这个时候使用此注解就不太方便了，原因在于这个注解中配置的cron表达式必须是常量，
        那么当我们修改定时参数的时候，就需要停止服务，重新部署。
        
        解决办法：
        
        方式一：
            
            实现SchedulingConfigure 接口，重写configureTasks 方法。重新制定Trigger，核心方法就是addTriggerTask(Runnable task, Trigger trigger) ，
            不过需要注意的是，此种方式修改了配制后，需要在下一次调度结束后，才会更新调度器。并不会在修改配置值时实时更新。实时更新需要在修改配置文件时
            额外增加相关逻辑处理。
          
          
          
        方式二：使用threadPoolTaskScheduler 类可实现动态添加删除功能，当然可实现频率的调整。
        
        首先,我们要认识一下这个调度类，它其对java 中ScheduledThreadPoolExcutor 的一个封装改进后的一个产物。主要改进有如下几点
        
        1.提供默认配置，因为是scheduleThreadPoolExecutor,所以只有poolSize 者一个默认值。
        2.支持自定义任务，通过传入Trigger 参数。
        3.对任务出错进行优化，如果是重复性的任务，不抛出异常，通过日志记录下来，不影响下次运行。如果只是执行一次任务则向上抛出异常。
        
        顺便说下ThreadPoolTaskExecutor相对于ThreadPoolExecutor的改进点
        1.提供默认配置，原生的threadPoolExecutor的除了ThreadFactory和RejectedExcutionhandel其他没有默认配置，
        2.实现AsyncListenableTaskExecutor接口，支持对FutureTask添加success和fail的回调，任务成功或失败的时候回执行对应回调方法。
        3.因为是spring的工具类，所以抛出的RejectedExecutionException也会被转换为spring框架的TaskRejectedException异常(这个无所谓)
        4.提供默认ThreadFactory实现，直接通过参数重载配置
            
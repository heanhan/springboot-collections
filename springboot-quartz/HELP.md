# Getting Started

### 定时任务 Documentation
For further reference, please consider the following sections:

* 使用springboot+quartz 方式实现定时任务。
        
      

    介绍：
            Quartz 是一款功能强大的任务调度器，可以实现较为复杂的调度功能。如每月一号执行，每天凌晨执行，每周五执行等等。还支持分布式任务调度。本文使用springboot+Mybatis
      +Quartz实现对定时任务的增、删、改、查、启用，停用等功能。并把定时任务持久化到数据库，以及支持集群。
    
    Quartz 的3个基本要素
        1.Schedule :调度器。所有的调度都是有它控制。
        2.Trigger :触发器。决定什么时候执行任务。
        3.JobDetail & Job :JobDetail 定义的是任务数据，而真正的执行逻辑在Job 中。使用JobDetail + Job  而不是Job .这是因为任务可能并发执行，
        如果schedule 直接使用Job ，就会存在对同一个实例并发访问的问题。而JobDeatail & Job 的方式 schedule 每次执行，
        都会根据JobDetail 创建一个新的Job 实例。这样就可以避免并发访问的问题。
         
        
    如何使用Quartz 
    
    1、添加依赖
        <dependency>  
            <groupId>org.quartz-scheduler</groupId>  
            <artifactId>quartz</artifactId>  
            <version>2.2.3</version>  
        </dependency> 
        <dependency>  
            <groupId>org.quartz-scheduler</groupId>  
            <artifactId>quartz-jobs</artifactId>  
            <version>2.2.3</version>  
        </dependency>
        
    2、创建配置文件
    在maven 项目中的resource目录下创建quartz.properties
    
    


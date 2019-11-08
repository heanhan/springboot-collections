# Getting Started

kafka和MQ的区别：

        1)在架构模型方面
        
            RabbitMQ遵循AMQP协议，RabbitMQ的broker由Exchange,Binding,queue组成，其中exchange和binding组成了消息的路由键；
            客户端Producer通过连接channel和server进行通信，Consumer从queue获取消息进行消费（长连接，queue有消息会推送到consumer端，
            consumer循环从输入流读取数据）。rabbitMQ以broker为中心；有消息的确认机制。
            kafka遵从一般的MQ结构，producer，broker，consumer，以consumer为中心，消息的消费信息保存的客户端consumer上，consumer根据消费的点，
            从broker上批量pull数据；无消息确认机制。
            
        2)在吞吐量
        
            rabbitMQ在吞吐量方面稍逊于kafka，他们的出发点不一样，rabbitMQ支持对消息的可靠的传递，支持事务，不支持批量的操作；
            基于存储的可靠性的要求存储可以采用内存或者硬盘。
            kafka具有高的吞吐量，内部采用消息的批量处理，zero-copy机制，数据的存储和获取是本地磁盘顺序批量操作，具有O(1)的复杂度，
            消息处理的效率很高。
            
        3)在可用性方面
        
            rabbitMQ支持miror的queue，主queue失效，miror queue接管。
            kafka的broker支持主备模式。
            
        4)在集群负载均衡方面
        
            rabbitMQ的负载均衡需要单独的loadbalancer进行支持。
            kafka采用zookeeper对集群中的broker、consumer进行管理，可以注册topic到zookeeper上；
            通过zookeeper的协调机制，producer保存对应topic的broker信息，可以随机或者轮询发送到broker上；
            并且producer可以基于语义指定分片，消息发送到broker的某分片上。
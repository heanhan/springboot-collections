package com.example.rabbitmq.mqconfig;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :
 */

@Configuration
public class QueenConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;


    /**
     * 初始化消息队列的属性
     */
    public void create(){

        //创建交换器 Exchange
        amqpAdmin.deleteExchange(String.valueOf(new DirectExchange("exchange.direct")));
        amqpAdmin.deleteExchange(String.valueOf(new DirectExchange("exchange.fanout")));
        amqpAdmin.deleteExchange(String.valueOf(new DirectExchange("exchange.topic")));

        //创建Queue
        amqpAdmin.declareQueue(new Queue("direct.queue",true));
        amqpAdmin.declareQueue(new Queue("fanout.queue",true));

        //绑定Queue
        amqpAdmin.declareBinding(new Binding("direct.queue", Binding.DestinationType.QUEUE,"exchange.direct","direct.queue",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue", Binding.DestinationType.QUEUE,"exchange.direct","direct.queue",null));
        amqpAdmin.declareBinding(new Binding("direct.queue", Binding.DestinationType.QUEUE,"exchange.fanout","",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue", Binding.DestinationType.QUEUE,"exchange.fanout","",null));
        amqpAdmin.declareBinding(new Binding("direct.queue", Binding.DestinationType.QUEUE,"exchange.topic","direct.#",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue", Binding.DestinationType.QUEUE,"exchange.topic","direct.*",null));

    }
}

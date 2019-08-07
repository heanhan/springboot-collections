package com.example.rabbitmq.mqservice;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :
 */

@Service
public class MQService {

    @RabbitListener(queues = "fanout.queue")
    public void receive(Message message) {
        System.out.println("收到消息 : " + new String(message.getBody()));

    }
}

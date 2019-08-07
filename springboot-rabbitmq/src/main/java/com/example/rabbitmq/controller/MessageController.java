package com.example.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :消息控制器
 */

@Slf4j
@RestController
@RequestMapping(value = "/rabbitmq")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * point 2 point
     */
    @GetMapping(value = "/send2Direct")
    public void send2Direct(){
        Map<String , Object> map = new HashMap<>();
        map.put( "msg" , "这是一条点对点消息" );
        map.put( "data" , Arrays.asList("helloworld" , 123 , true) );

        rabbitTemplate.convertAndSend( "exchange.direct" , "direct.queue" , map );
    }


    @GetMapping(value = "/send2Topic")
    public void send2Topic() {
        Map<String , Object> map = new HashMap<>();
        map.put( "msg" , "这是一条广播消息" );
        map.put( "data" , Arrays.asList("topic消息" , 123 , true) );

        rabbitTemplate.convertAndSend( "exchange.fanout" , "", map );

    }


    @GetMapping(value = "/receive")
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert( "direct.queue" );
        o.getClass();
        System.out.println(o.getClass());
        System.out.println(o);
    }


}

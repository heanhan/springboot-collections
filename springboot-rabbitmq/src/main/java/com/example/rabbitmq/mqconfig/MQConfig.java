package com.example.rabbitmq.mqconfig;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :自定义消息队列的消息转换器 默认的是jdk的序列化转换器，然后自定义为json
 *
 */

@Configuration
public class MQConfig {

    @Bean
    public MessageConverter messageCoverter(){

        return new Jackson2JsonMessageConverter();
    }
}

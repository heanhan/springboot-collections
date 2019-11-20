package com.example.kafka.listener;

import com.example.kafka.entiry.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhaojh
 * @date : 2019-11-20
 * @function :
 */

@Slf4j
@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "test", groupId = "test-consumer")
    public void listen(Message message) {
        log.info("接收消息: {}", message);
    }
}

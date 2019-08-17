package com.example.messages.listener;

import com.aliyuncs.exceptions.ClientException;
import com.example.messages.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : zhaojh
 * @date : 2019-08-17
 * @function :  短信的监听
 */

@Slf4j
@Component
@RabbitListener(queues = "message")
public class MessageListener {

    @Autowired
    private MessageUtil messageUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;//模板编号

//    @Value("${aliyun.sms.sign_name}")
    private String sign_name="微服务聊天";//签名

    /**
     * 发送短信功能
     */
    @RabbitHandler
    public void sendMessage(Map<String,String> map){

        log.info("解析发送短信信息");

        String telphone= map.get("telphone");
        String code= map.get("code");
        messageUtil.sendSms(telphone,template_code,sign_name,"\"code\":\""+code+"\"}");
    }
}

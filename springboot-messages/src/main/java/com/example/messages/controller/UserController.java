package com.example.messages.controller;

import com.example.messages.pojo.User;
import com.example.messages.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : zhaojh
 * @date : 2019-08-17
 * @function : 用户的控制器
 */

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     *
     * @param user 用户信息
     * @return  tip
     */
    @PostMapping(value = "/userRegister")
    public String userRegister(User user){
        return null;
    }

    /**
     *
     * @param telphone 电话号码
     * @return  返回六位数的验证码
     */
    @PostMapping(value= "/validateCode")
    public void validateCode(String telphone){
        /**
         * 生成随机数  六位数字
         *
         */

        Random random = new Random();
        int min=100000;
        int max=999999;
        int validateCode=random.nextInt(max);//产生一个六位数的随机码
        if(validateCode<min){
            //如果随机数小于最小六位数，进行相加，保证是六位数
            validateCode=validateCode+min;
        }
        log.info("得到的六位数验证码："+validateCode);
        //将验证码放到redis 中进行缓存，用来比对，用户最终提交的信息验证。
        redisUtil.set("telphone",validateCode,300);//用电话号码作为key ,验证码为value,最后一位是失效时间  ：秒

        /**
         * 将验证码发送到rabbitmq 消息队列中
         */
        Map<String, String> map = new HashMap<>();
        map.put("telphone",telphone);//是指电话号码
        map.put("validateCode",validateCode+"");
        rabbitTemplate.convertAndSend("message",map);
    }
}

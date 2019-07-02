package com.example.smsstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SMS配置属性
 * 使用@ConfigurationProperties注解可以将配置文件yml/properites
 */
@Data
@ConfigurationProperties(prefix = "spring.sms.config")
public class SmsProperties {

    private String appid;
    private String accountSid;
    private String authToken;
}

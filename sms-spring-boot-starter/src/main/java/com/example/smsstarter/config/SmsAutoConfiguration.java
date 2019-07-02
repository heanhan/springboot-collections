package com.example.smsstarter.config;


import com.example.smsstarter.core.SMSService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 短信自动配置类
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)//使@ConfigurationProperties注解生效
public class SmsAutoConfiguration {

    @Bean
    public SMSService getBean(SmsProperties smsProperties){
        SMSService smsService = new SMSService(smsProperties);
        return smsService;
    }
}

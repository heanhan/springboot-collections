package com.example.crossorigin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : zhaojh
 * @date : 2019-07-18
 * @function : 资源控制器，可以配置跨域 注册拦截器 ，消息转换
 */

@Configuration
public class CorssOriginConfig extends WebMvcConfigurationSupport {


    /**
     * 注册添加添加跨域的配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         *    /** 释放拦截的所有的请求资源
         */
        registry.addMapping("/**");
    }
}

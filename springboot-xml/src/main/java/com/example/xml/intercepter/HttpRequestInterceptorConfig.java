package com.example.xml.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : zhaojh
 * @date : 2019-07-11
 * @function :注册http请求的拦截器
 */

@Component
@Slf4j
public class HttpRequestInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入拦截器--->开始注册");
        //注册连接器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new HttpRequestIntercepter());
        //配置拦截的拦截路径
        interceptorRegistration.addPathPatterns("/requestXml");
        //配置不拦截的路径
//        interceptorRegistration.excludePathPatterns("/");

    }


}

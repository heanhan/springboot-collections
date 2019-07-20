package com.example.jpa.config;

import com.example.jpa.interceptor.UserInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : zhaojh
 * @date : 2019-07-13
 * @function : 请求资源的注册  实现类WebMvcConfigurer
 */

@Configuration
@Slf4j
public class WebMvcRegister extends WebMvcConfigurationSupport {

    /**
     * 注册拦截期
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入拦截器的注册......");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

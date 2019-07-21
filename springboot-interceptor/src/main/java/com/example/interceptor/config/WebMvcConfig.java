package com.example.interceptor.config;

import com.example.interceptor.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : zhaojh
 * @date : 2019-07-21
 * @function :
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**")
                .order(1);
    }


}

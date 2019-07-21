package com.example.interceptor.config;

import com.example.interceptor.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhaojh
 * @date : 2019-07-21
 * @function :
 */

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean httpServletRequestReplacedRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("uerFilter");
        registration.setOrder(1);
        return registration;
    }
}

package com.example.xml.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zhaojh
 * @date : 2019-07-11
 * @function : 请求的拦截器
 */
@Slf4j
public class HttpRequestIntercepter implements HandlerInterceptor {

    /**
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return
     * @throws Exception
     */
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        log.info("进入拦截器内部，开始拦截。。。。");

        return true;
    }
}

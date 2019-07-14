package com.example.xml.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : zhaojh
 * @date : 2019-07-11
 * @function : 请求的拦截器
 */
@Slf4j
public class HttpRequestIntercepter implements HandlerInterceptor {

    /**
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        log.info("进入拦截器内部，开始拦截。。。。");
        log.info("请求的ip:" + request.getRemoteAddr() + "请求的方法：" + request.getMethod());

        int len = request.getContentLength();
        System.out.println("数据流长度:" + len);
        //获取HTTP请求的输入流
        InputStream is = request.getInputStream();
        //已HTTP请求输入流建立一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        //读取HTTP请求内容
        String buffer = null;
        StringBuffer sb = new StringBuffer();

        while (br.readLine() != null) {
            //在页面中显示读取到的请求参数
            sb.append(buffer + "\n");
        }
        System.out.println("接收post发送数据:\n" + sb.toString().trim());


        return true;
    }
}

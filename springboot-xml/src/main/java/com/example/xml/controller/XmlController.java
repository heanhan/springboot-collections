package com.example.xml.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : zhaojh
 * @date : 2019-07-11
 * @function :  接收报文请求
 */

@RestController
@RequestMapping(value="/requestXml")
@Slf4j
public class XmlController {


    /**
     * 请求的拦截xml
     */

    @PostMapping(value="/postXml")
    public void postXml(HttpServletRequest request) throws IOException {
        log.info("进入controller....");
        log.info("请求的ip:"+request.getRemoteAddr()+"请求的方法："+request.getMethod());

        int len = request.getContentLength();
        System.out.println("数据流长度:" +len);
        //获取HTTP请求的输入流
        InputStream is = request.getInputStream();
        //已HTTP请求输入流建立一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        //读取HTTP请求内容
        String buffer = null;
        StringBuffer sb = new StringBuffer();
        while ((buffer = br.readLine()) != null) {
            //在页面中显示读取到的请求参数
            sb.append(buffer+"\n");
        }
        System.out.println("接收post发送数据:\n"+sb.toString().trim());
    }
}

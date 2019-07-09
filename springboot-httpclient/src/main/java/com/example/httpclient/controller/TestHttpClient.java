package com.example.httpclient.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.httpclient.util.HttpClientUtil;
import com.example.httpclient.util.Httpclient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestHttpClient {

    @RequestMapping("/httpPost")
    public String test(){
        Map<String, Object> param=new HashMap<>();
        param.put("A1","A1");
        param.put("A2","A2");
        param.put("A3","A3");
        param.put("A4","A4");
        param.put("A5","A5");
        param.put("A6","A6");
        System.out.println("请求");
        String postContent = HttpClientUtil.doPost("http://127.0.0.1:9306/testPost", param);

        return postContent;
    }


    /**
     * 测试HttpClient     请求
     *
     */

    @RequestMapping(value="/testHttpClient")
    public String testHttpClient(){
        Map<String, Object> param=new HashMap<>();
        param.put("A1","A1");
        param.put("A2","A2");
        param.put("A3","A3");
        param.put("A4","A4");
        param.put("A5","A5");
        param.put("A6","A6");
        System.out.println("请求");
        JSONObject json = new JSONObject(param);
        Httpclient.httpPost("http://127.0.0.1:9309/create", json);
        return "请求成功！";
    }
}

package com.example.web.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
public class TestPost {

    @PostMapping("/testPost")
    public String requestPost(HttpServletRequest request) throws IOException {
        System.out.println("获取参数：");
//        Set<Map.Entry<String, Object>> entries = param.entrySet();
//        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, Object> next = iterator.next();
//            String key = next.getKey();
//            Object value = next.getValue();
//            System.out.println("或取得key:"+key+"获取的value:"+value);
//        }
        String a1 = request.getParameter("A1");
        System.out.println("输出a1" + a1);

        String a2 = request.getParameter("param");
        System.out.println("输出a2" + a2);

        String string = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("输出string" + string);
        return "请求成功！";
    }


    /**
     * 创建异常信息请求
     *
     * @param requestBody 请求消息内容
     * @param request     请求消息头
     * @return jsonObject
     */

    @PostMapping(value = "/create")
    public String createExceptionInfo(@RequestBody String requestBody, HttpServletRequest request) {

        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        Map<String, Object> param = (Map<String, Object>) jsonObject;

        Set<Map.Entry<String, Object>> entries = param.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println("或取得key:" + key + "获取的value:" + value);
        }
        //返回请求结果
        return null;

    }


}

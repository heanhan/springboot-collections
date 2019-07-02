package com.example.smsstarter.core;

import com.alibaba.fastjson.JSONObject;
import com.example.smsstarter.config.SmsProperties;
import com.example.smsstarter.pojo.ENUM_SMSAPI_URL;
import com.example.smsstarter.pojo.SendSMSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * 短信的核心类
 */
public class SMSService {

    @Autowired
    private RestTemplate restTemplate;
    private String appid;
    private String accountSid;
    private String authToken;

    /**
     * 初始化
     */
    public SMSService(SmsProperties smsProperties){
        this.appid=smsProperties.getAppid();
        this.accountSid=smsProperties.getAccountSid();
        this.authToken=smsProperties.getAuthToken();

    }

    /**
     * 单独发送短信
     *
     */
    public String sendSMS(SendSMSDTO sendSMSDTO){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("sid",accountSid);
        jsonObject.put("token",authToken);
        jsonObject.put("appid",appid);
        jsonObject.put("templateid",sendSMSDTO.getTemplateid());
        jsonObject.put("param",sendSMSDTO.getParam());
        jsonObject.put("mobile",sendSMSDTO.getMobile());

        if (sendSMSDTO.getUid()!=null){
            jsonObject.put("uid",sendSMSDTO.getUid());
        }else{
            jsonObject.put("uid","");
        }
        String json=JSONObject.toJSONString(jsonObject);
        //使用RestTemplate 进行远程http访问
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity =new HttpEntity<String>(json,headers);
        String result = restTemplate.patchForObject(ENUM_SMSAPI_URL.SENDSMS.getUrl(), httpEntity, String.class);

        return result;

    }

}

package com.example.smsstarter.pojo;



/**
 * 短信请求的API枚举
 */
public enum ENUM_SMSAPI_URL {


    SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
    SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");
    private String url;
    ENUM_SMSAPI_URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

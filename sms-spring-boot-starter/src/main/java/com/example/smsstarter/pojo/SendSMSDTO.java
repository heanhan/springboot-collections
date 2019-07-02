package com.example.smsstarter.pojo;

import lombok.Data;

@Data
public class SendSMSDTO {

    /**
     * 模板templateid
     */
    private String templateid;


    /**
     * 参数
     */

    private String param;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户穿透id ,可以为空
     */
    private String uid;
}

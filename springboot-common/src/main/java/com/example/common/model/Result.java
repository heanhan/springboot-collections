package com.example.common.model;



import lombok.Data;

import java.io.Serializable;



@Data
public class Result implements Serializable {

    private boolean flag;//请求的状态的标识
    private Integer code;//请求响应码
    private String  message;//返回的信息
    private Object data;//返回的数据

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

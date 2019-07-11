package com.example.httpclient.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static JSONObject toJson(String str){

        JSONObject json = JSONObject.parseObject(str);
        System.out.println(json);
        return json;

    }

    public static void main(String[] args) {
        String str="{NOTICE_TYPE=NOTICE_POLICY, PROV=270, TYPE=NOTICE_TOKEN_APPLY, TASK_ID=ddd745fabed8355f1d7baadb303d989a}";

        JSONObject jsonObject = toJson(str);
        System.out.println(jsonObject);
    }
}



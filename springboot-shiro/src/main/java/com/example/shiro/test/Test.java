package com.example.shiro.test;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String str = "{NOTICE_TYPE=NOTICE_POLICY, PROV=270, TYPE=NOTICE_TOKEN_APPLY, TASK_ID=7dfbe0fbaf2a4b0ba34829152440eb32}";
//        JSONObject map = mapStringToMap(str);
//        System.out.println(map);

        mapStringToMap();


    }

    public static void mapStringToMap() {

        //mapString
        String mapString = "{NOTICE_TYPE=NOTICE_POLICY, PROV=270, TYPE=NOTICE_TOKEN_APPLY, TASK_ID=7dfbe0fbaf2a4b0ba34829152440eb32},}";
        String str1 = mapString.replaceAll("\\{|\\}", "");
        String str2 = str1.replaceAll(" ", "");
        String str3 = str2.replaceAll(",", "&");
        Map<String, String> map = null;
        if ((null != str3) && (!"".equals(str3.trim()))) {
            String[] resArray = str3.split("&");
            if (0 != resArray.length) {
                map = new HashMap(resArray.length);
                for (String arrayStr : resArray) {
                    if ((null != arrayStr) && (!"".equals(arrayStr.trim()))) {
                        int index = arrayStr.indexOf("=");
                        if (-1 != index) {
                            map.put(arrayStr.substring(0, index), arrayStr.substring(index + 1));
                        }
                    }
                }
            }
        }

        System.out.println(map);

        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);


    }
}

package com.example.methods;

/**
 * @author : zhaojh
 * @date : 2019-07-12
 * @function :
 */

public class xx {

    /**
     *
     */


    public static void main(String[] args) {
        String s="NOTICE_SCANNER_VERSION_270_20190712_092458_48ec1af8e61da7c55e3b49506535902e_1_1.zip";
        String[] ss=s.split("_");
        ss[6]="888888888888888888";
        StringBuffer sb=new  StringBuffer();
        for(int i=0;i<ss.length;i++){
            if(i<ss.length-1){
                sb.append(ss[i]+"_");
            }else if(i==ss.length-1){
                sb.append(ss[i]);
            }
        }
        String zipPaths=sb.toString();
        System.out.println("打印拼装的结果："+zipPaths);
    }

}

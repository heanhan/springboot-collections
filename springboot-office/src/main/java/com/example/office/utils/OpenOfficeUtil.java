package com.example.office.utils;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @author : zhaojh
 * @date : 2019-11-29
 * @function :
 */

public class OpenOfficeUtil {


    /**
     * 返回一个安装路径
     * @return
     */
    public static String getOfficeHome(){
        String osName= System.getProperty("os.name");
        System.out.println("操作系统名称："+osName);
        if(Pattern.matches("Linux.*",osName)){
            return "/opt/openoffice.org4";
        }else if(Pattern.matches("Windows.*",osName)){
            return "";
        }else if(Pattern.matches("Mac.*",osName)){
            return "/Application/OpenOffice.org.agg/Contents";

        }
        return null;
    }


}

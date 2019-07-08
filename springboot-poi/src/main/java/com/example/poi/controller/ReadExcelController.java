package com.example.poi.controller;

import ch.qos.logback.core.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value="readExcel")
@Slf4j
public class ReadExcelController {

    /**
     * 读取Excel
     *  分两种分别读取
     */
    @GetMapping(value="/readExcel")
    public void readExcel(MultipartFile excelFile) throws IOException {
        /**
         * 操作步骤：
         *  1、获取文件名，
         *  2、根据判断文件名后缀，选择使用xls或者xlsx的读取方式
         *  3、
         *  4、
         *
         */

        //获取文件名
        String originalFilename = excelFile.getOriginalFilename();
        //获取文件的后缀
        if(originalFilename.endsWith(".xls")){
           

        }
        else if(originalFilename.endsWith(".xlsx")){


        }else{
            log.info("导入的Excel的格式。");
        }
    }
}

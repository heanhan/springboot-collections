package com.example.office.controller;

import org.apache.commons.io.IOUtils;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author : zhaojh
 * @date : 2019-11-29
 * @function :
 */

@Controller
public class MyController {

    // 第一步：转换器直接注入
    @Autowired
    private DocumentConverter converter;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping("toPdfFile")
    public String toPdfFile() {
        //com/example/office/controller/信息系统安全等级保护备案表.doc
        File file = new File("D:\\work_contents\\2019year\\2019合规项目\\合规总结一些表库以及业务关系.docx");//需要转换的文件
        try {
            File newFile = new File("D:/obj-pdf");//转换之后文件生成的地址
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            //文件转化
            converter.convert(file).to(new File("D:/obj-pdf/hello.pdf")).execute();
            //使用response,将pdf文件以流的方式发送的前段
            ServletOutputStream outputStream = response.getOutputStream();
            InputStream in = new FileInputStream(new File("D:/obj-pdf/hello.pdf"));// 读取文件
            // copy文件
            int i = IOUtils.copy(in, outputStream);
            System.out.println(i);
            in.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "This is to pdf";
    }
}

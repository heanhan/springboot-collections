package com.example.files.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


@RestController
@RequestMapping(value = "/file")
public class FileController {

    private String fileUrlPath;
    private HttpServletResponse response;

    @RequestMapping("/downloadFile")
    private String downloadFile(@RequestParam(required = false) String fileUrlPath, HttpServletResponse response) {

        String downloadFilePath = null;//被下载的文件在服务器中的路径,
        String fileName = null;//被下载文件的名称
        if ("".equals(fileUrlPath) || fileUrlPath == null) {
            downloadFilePath = "D:/springboot-collections/springboot-file/";//被下载的文件在服务器中的路径,
            fileName = "demo.xml";//被下载文件的名称
        }

        downloadFilePath=fileUrlPath;
        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}

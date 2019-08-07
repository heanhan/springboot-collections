package com.example.files.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@RestController
@RequestMapping(value = "/file")
@SuppressWarnings(value = "all")
@Slf4j
public class FileController {

    private String fileUrlPath;

    @Autowired
    private HttpServletResponse responses;

    @RequestMapping("/downloadFile")
    private String downloadFile(@RequestParam(required = false) String fileUrlPath, HttpServletResponse response) {

        String downloadFilePath = null;//被下载的文件在服务器中的路径,
        String fileName = null;//被下载文件的名称
        if ("".equals(fileUrlPath) || fileUrlPath == null) {
            downloadFilePath = "D:/springboot-collections/springboot-file/";//被下载的文件在服务器中的路径,
            fileName = "demo.xml";//被下载文件的名称
        }

        downloadFilePath = fileUrlPath;
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


    /**
     * 下载当前项目下的文件
     * <p>
     * 最省事的做法前端直接（jQuery  写法）
     * <p>
     * function fileDownload() {
     * var url = "/files/test.xlsx";
     * window.location.href = url;
     * }
     */
    @GetMapping(value = "/downTemplate")
    public String downTemplate() throws IOException {
        Resource resource = new ClassPathResource("files/test.xlsx");
        File file = resource.getFile();
        String filename = resource.getFilename();
        if (file.exists()) {
            /**
             * 设置下载
             */
            // 设置强制下载不打开
            responses.setContentType("application/force-download");
            responses.addHeader("Content-Disposition", "attachment;fileName=" + filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = responses.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
                responses.setHeader("Content-Length", String.valueOf(fis.available()));

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
        return "下载失败！";
    }

    /**
     * 下载项目路径下的模板
     * @return String
     */

    @GetMapping(value = "/getApplicationTemplate")
    public String getApplicationTemplate() {
        try {

            //获取要下载的模板名称
            String fileName = "ApplicationImportTemplate.xlsx";
            //读取文件
            ClassPathResource classPathResource =new ClassPathResource("files/ApplicationImportTemplate.xlsx");
            InputStream inputStream = classPathResource.getInputStream();
            // 设置强制下载不打开
            responses.setContentType("application/force-download");
            //设置要下载的文件的名称
            responses.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
//            responses.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            OutputStream out = responses.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            responses.setHeader("Content-Length", String.valueOf(inputStream.available()));
            inputStream.close();
            return "应用导入模板下载完成";
        } catch (Exception ex) {
            log.error("getApplicationTemplate :", ex);
            return "应用导入模板下载失败！";
        }
    }
}

package com.example.pdf.controller;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhaojh
 * @date : 2019-07-17
 * @function : 使用pdf
 */

@RestController
@RequestMapping(value="pdf")
@Slf4j
public class PdfController {

    @Value("${font}")
    private String font;

    @Value("${fileName}")
    private String fileName;

    @GetMapping(value="/hello")
    public String hello(HttpServletResponse response) throws Exception{
      log.info("开始进入PFD控制器......");
//      String file="D:"+File.separator+"springboot-collections"+File.separator+"springboot-pdf"+File.separator+"hello.pdf";
//      PdfUtil.creatPDF(file,null);

        //需要填充的数据
        Map<String, Object> data = new HashMap<>(16);
        data.put("name", "kevin");
        JSONObject json = new JSONObject(data);
        String content = json.toJSONString();
        //创建pdf
        createPdf(content, fileName);
        // 读取pdf并预览
        readPdf(response);
      log.info("pdf创建完成");
      return null;
    }


    public  void createPdf(String content,String dest) throws IOException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A4);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(font);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(content.getBytes("UTF-8")), null, Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();

    }

    /**
     * 读取本地pdf,这里设置的是预览
     */
    private void readPdf(HttpServletResponse response) {
        response.reset();
        response.setContentType("application/pdf");
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
            response.setHeader("Content-Disposition",
                    "inline; filename= file");
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

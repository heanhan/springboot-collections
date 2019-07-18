package com.example.pdf.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author : zhaojh
 * @date : 2019-07-17
 * @function :pdf的工具类
 */

public class PdfUtil {

    /**
     *
     * @param fileName  文件名
     * @param content  需要打印的pdf 纸张大小：
     */
    public  void createPdf(String content,String fileName) throws IOException, DocumentException {
        String font="simhei.ttf";
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
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
     * 使用jdk 8特性使用try wtith....
     */

//    private static void printFileJava7() throws IOException {
//
//        try(FileInputStream input = new FileInputStream("file.txt")) {
//
//            int data = input.read();
//
//            while(data != -1){
//                System.out.print((char) data);
//                data = input.read();
//            }
//        }
//    }
}

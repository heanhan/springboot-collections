package com.example.poi.word;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;

import java.io.FileOutputStream;

/**
 * @author : zhaojh
 * @date : 2019-05-13
 * @function :
 */

public class WordItext {

    public static void main(String[] args) {
        try {
            /** 创建Document对象(word文档) **/
            Rectangle rectPageSize = new Rectangle(PageSize.A4);
            rectPageSize = rectPageSize.rotate();

            // 创建word文档,并设置纸张的大小
            Document doc = new Document(PageSize.A4);
            String fileName = "D:\\poi\\word\\test1.docx";

            /**
             * 建立一个书写器与document对象关联,通过书写器可以将文档写入到输出流中
             */
            RtfWriter2.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            // 在列中添加图片
            Paragraph p1 = new Paragraph("Hello World ");
            doc.add(p1);

            Image png = Image.getInstance("D:\\poi\\word\\head.jpg");
            doc.add(png);


            Paragraph p = new Paragraph("Hello World ");
            doc.add(p);

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

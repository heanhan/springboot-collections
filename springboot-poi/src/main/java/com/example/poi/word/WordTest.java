package com.example.poi.word;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : zhaojh
 * @date : 2019-06-18
 * @function :
 */

public class WordTest {

    public static void main(String[] args) throws Exception{
        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph title = doc.createParagraph();
        XWPFRun run = title.createRun();
        run.setText("Fig.1 A Natural Scene");
        run.setBold(true);
        title.setAlignment(ParagraphAlignment.CENTER);

        String imgFile = "D:\\poi\\word\\head.jpg";
        FileInputStream is = new FileInputStream(imgFile);
        run.addBreak();
        run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
        is.close();

        FileOutputStream fos = new FileOutputStream("D:\\poi\\word\\test.docx");
        doc.write(fos);
        fos.close();
    }
}

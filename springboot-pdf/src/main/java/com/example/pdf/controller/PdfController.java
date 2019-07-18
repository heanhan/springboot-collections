package com.example.pdf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author : zhaojh
 * @date : 2019-07-17
 * @function : 使用pdf
 */

@RestController
@RequestMapping(value="pdf")
@Slf4j
public class PdfController {

    @GetMapping(value="/creatPdf")
    public void creatPdf() throws  Exception{
        //Step 1: 实例化文档对象，设置文档背景，大小等
        Rectangle rectPageSize = new Rectangle(PageSize.A4);// A4纸张
        rectPageSize.setBackgroundColor(BaseColor.BLUE);//文档的背景色
        //创建一个文档对象，设置初始化大小和页边距
        Document document = new Document(rectPageSize, 40, 40, 40, 40);// 上、下、左、右间距
        //Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        //Step 2: 创建 PdfWriter 对象:第一个参数是文档对象的引用，第二个参数是输出将写入的文件的绝对名称
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("./ITextTest.pdf"));
        //Step 3: 打开文档对象
        document.open();
        //Step 4: 向文档中添加内容
        //iText中用文本块(Chunk)、短语(Phrase)和段落(paragraph)处理文本。
        //1. 创建文本块对象
        //文本块(Chunk)是处理文本的最小单位，有一串带格式（包括字体、颜色、大小）的字符串组成。
        Chunk chunk1 = new Chunk("This text is underlined", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE));
        document.add(chunk1);
        //2. 创建短语对象
        //短语(Phrase)由一个或多个文本块(Chunk)组成，短语(Phrase)也可以设定字体，但对于其中已设定过字体的文本块(Chunk)无效。
        //通过短语(Phrase)成员函数add可以将一个文本块(Chunk)加到短语(Phrase)中，如：phrase.add(chunk);
        Phrase phrase1 = new Phrase("The first Phrase");
        document.add(phrase1);
        Phrase phrase2 = new Phrase();
        phrase2.add(chunk1);
        document.add(phrase2);
        //3. 创建段落对象
        //段落(paragraph)由一个或多个文本块(Chunk)或短语(Phrase)组成，相当于WORD文档中的段落概念，
        //同样可以设定段落的字体大小、颜色等属性。另外也可以设定段落的首行缩进、对齐方式（左对齐、右对齐、居中对齐）。
        //通过函数setAlignment可以设定段落的对齐方式，setAlignment的参数1为居中对齐、2为右对齐、3为左对齐，默认为左对齐。
        Anchor anchorTarget = new Anchor("First page of the document.");//创建定位符（链接）
        anchorTarget.setName("BackToTop");//当单击 backToTop 链接时，它会将您带到文档的第一页
        Paragraph paragraph1 = new Paragraph();//创建一段段落
        paragraph1.setSpacingBefore(50);//设置上边距
        paragraph1.add(anchorTarget);//将定位符添加到段落中
        document.add(paragraph1);//将段落添加到文档中
        //使用文本以及字体、颜色、字号等默认设置创建一个默认段落
        document.add(new Paragraph("Some more text on the first page with different color and font type.",
                FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,new CMYKColor(0, 255, 0, 0))));
        //4. 创建章对象
        //章是一种特殊的节，它从一个新页开始且默认会显示一个编号。
        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(
                FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0,255, 255, 17)));
        Chapter chapter1 = new Chapter(title1, 1);//创建章（内容，编号）
        chapter1.setNumberDepth(0);//将编号深度设置为 0，这样就不会在页面上显示章编号
        //5. 创建节对象.节是章的子元素
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1",
                FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,new CMYKColor(0, 255, 255, 17)));
        Section section1 = chapter1.addSection(title11);//创建节
        Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");
        section1.add(someSectionText);//在节下添加一些文本
        someSectionText = new Paragraph("Following is a 3 X 2 table.");
        section1.add(someSectionText);
        //6. 创建表格对象Table (int columns)、Table(int columns, int rows)
        //创建表格时必须指定表格的列数，而对于行数可以不用指定
        PdfPTable t = new PdfPTable(3);//创建一个3列表格对象
        t.setSpacingBefore(25);//设置上边距
        t.setSpacingAfter(25);//设置下边距
        PdfPCell c1 = new PdfPCell(new Phrase("Header1"));
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
        t.addCell(c3);
        t.addCell("1.1");
        t.addCell("1.2");
        t.addCell("1.3");
        section1.add(t);
        //7. 创建列表对象
        //列表包含多个 ListItem。一个列表可带有编号，也可不带编号。
        //将第一个参数作为 true 传送，表明您希望创建带编号的列表。
        List l = new List(true, false, 10);
        l.add(new ListItem("First item of list"));
        l.add(new ListItem("Second item of list"));
        section1.add(l);
        //8. 将 Image 添加到主 Document 中
        //目前iText支持的图像格式有：GIF, Jpeg, PNG, wmf等格式，对于不同的图像格式，iText用同样的构造函数自动识别图像格式。
        //图像的位置主要是指图像在文档中的对齐方式、图像和文本的位置关系。
        //IText中通过函数public void setAlignment(int alignment)进行处理，
        //参数alignment为Image.RIGHT、Image.MIDDLE、Image.LEFT分别指右对齐、居中、左对齐；
        //当参数alignment为Image.TEXTWRAP、Image.UNDERLYING分别指文字绕图形显示、图形作为文字的背景显示。
        //这两种参数可以结合以达到预期的效果，如setAlignment(Image.RIGHT|Image.TEXTWRAP)显示的效果为图像右对齐，文字围绕图像显示。
        //Image 方法缩放图像：scaleAbsolute()、scaleAbsoluteWidth()、scaleAbsoluteHeight()、scalePercentage()、scaleToFit()等
        //函数public void scaleAbsolute(int newWidth, int newHeight)直接设定显示尺寸；
        //函数public void scalePercent(int percent)设定显示比例，如scalePercent(50)表示显示的大小为原尺寸的50%；
        //而函数scalePercent(int percentX, int percentY)则设定图像高宽的显示比例。
        //如果图像需要旋转一定角度之后在文档中显示，可以通过函数public void setRotation(double r)设定，
        //参数r为弧度，如果旋转角度为30度，则参数r= Math.PI / 6。
//        Image image2 = Image.getInstance("D:\\springboot-collections\\springboot-pdf\\平凡之路.jpg");
//        image2.scaleAbsolute(120f, 120f);
//        section1.add(image2);
        //9. 将定位符添加到主文档中
        Paragraph title2 = new Paragraph("Using Anchor", FontFactory.getFont(
                FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 0,0)));
        section1.add(title2);
        title2.setSpacingBefore(5000);
        Anchor anchor2 = new Anchor("Back To Top");
        anchor2.setReference("#BackToTop");//设置引用
        section1.add(anchor2);
        //10. 将一章添加到主文档中
        document.add(chapter1);
        //11. 中文处理
        //默认的iText字体设置不支持中文字体，需要下载远东字体包iTextAsian.jar，否则不能往PDF文档中输出中文字体。
        //BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //没有字体包的话，可以调用系统自身的字体来使用
        //simsun.ttc:简体中文，msyhl.ttc:微软雅黑
        //注意：在.ttc后一定要加,1
        BaseFont bfChinese = BaseFont.createFont("c://windows//fonts//msyhl.ttc,1",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12,Font.NORMAL);
        String content="默认的iText字体设置不支持中文字体，需要下载远东字体包iTextAsian.jar，"
                + "否则不能往PDF文档中输出中文字体。\n　iText的安装非常方便，"
                + "在http://www.lowagie.com/iText/download.html - download 网站上下载iText.jar文件后，"
                + "只需要在系统的CLASSPATH中加入iText.jar的路径，在程序中就可以使用iText类库了。"
                + "\n 本地化测试包括繁体\n本地化測試包括繁體";
        Paragraph pragraph=new Paragraph(content, fontChinese);
        document.add(pragraph);
        //Step 4:关闭文档对象
        document.close();
    }


}

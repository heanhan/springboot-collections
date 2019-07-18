package com.example.pdf.utils;


import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author : zhaojh
 * @date : 2019-07-17
 * @function :pdf的工具类
 */

public class CreatePDF {

    private Document document = null;

    /**
     * 功能：创建导出数据的目标文档
     * @param fileName 存储文件的临时路径
     */
    public void createDocument(String fileName) {
        String path="D:"+File.separator+"springboot-collections"+File.separator+"springboot-pdf"+File.separator;
        File file = new File(path+fileName);
        FileOutputStream out = null;
        document = new Document(PageSize.A4,50,50,50,50);
        try {
            out = new FileOutputStream(file);
            PdfWriter.getInstance(document, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 打开文档准备写入内容
        document.open();
    }

    /**
     * 功能：创造字体格式
     * @param fontname
     * @param size 字体大小
     * @param style 字体风格
     * @param color 字体颜色
     * @return Font
     */
    public static Font createFont(String fontname, float size, int style, BaseColor color) {
        Font font =  FontFactory.getFont(fontname, size, style, color);
        return font;
    }

    /**
     * 功能： 返回支持中文的字体
     * @param fontStr 指定字体所在位置
     * @param size 字体大小
     * @param style 字体风格
     * @param color 字体 颜色
     * @return  字体格式
     */
    public static Font createChineseFont(String fontStr,float size,int style,BaseColor color){
        BaseFont bfChinese = null;
        try {
            bfChinese = BaseFont.createFont(fontStr+",1",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Font(bfChinese, size, style, color);
    }

    /**
     * 功能： 返回支持中文的字体---微软雅黑
     * @param size 字体大小
     * @param style 字体风格
     * @param color 字体 颜色
     * @return  字体格式
     */
    public static Font createChineseFont(float size, int style, BaseColor color) {
        return createChineseFont("c://windows//fonts//msyhl.ttc", size, style, color);
    }

    /**
     * 功能：向PDF文档中添加短语
     * @param text 内容
     * @param font 内容对应的字体
     * @return phrase 指定字体格式的内容
     */
    public static Phrase createPhrase(String text,Font font) {
        Phrase phrase = new Phrase(text,font);
        return phrase;
    }

    /**
     * 功能：向PDF文档中添加段落
     * @param text 内容
     * @param font 内容对应的字体
     * @return Paraggraph 指定字体格式的内容
     */
    public static Paragraph createParagraph(String text,Font font) {
        Paragraph paragraph = new Paragraph(text,font);
        return paragraph;
    }

    /**
     * 创建链接
     * @param text 内容
     * @param target 链接的名称
     * @return 链接
     */
    public static Anchor setAnchor(String text,String target){
        Anchor anchorTarget = new Anchor(text);//创建定位符（链接）
        anchorTarget.setName(target);//当单击 target 链接时，它会将您带到文档的第一页
        return anchorTarget;
    }

    /**
     * 功能  创建PDF文档中的章节
     * @param title 章节标题
     * @param chapterNum 章节序列号
     * @param alignment 0表示align=left，1表示align=center
     * @param numberDepth 章节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
     * @param font 字体格式
     * @return Chapter章节
     */
    public static Chapter createChapter(String title, int chapterNum, int alignment, int numberDepth, Font font) {
        Paragraph chapterTitle = new Paragraph(title, font);
        chapterTitle.setAlignment(alignment);
        Chapter chapter = new Chapter(chapterTitle, chapterNum);
        chapter.setNumberDepth(numberDepth);
        return chapter;
    }

    /**
     * 功能：创建某指定章节下的小节
     * @param chapter 指定章节
     * @param title 小节标题
     * @param font 字体格式
     * @param numberDepth 小节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
     * @return section在指定章节后追加小节
     */
    public static Section createSection(Chapter chapter, String title, Font font, int numberDepth) {
        Section section = null;
        if(chapter != null) {
            Paragraph sectionTitle = new Paragraph(title, font);
            sectionTitle.setSpacingBefore(20);
            section = chapter.addSection(sectionTitle);
            section.setNumberDepth(numberDepth);
        }
        return section;
    }

    /**
     * 创建表格
     * @param colnum 列数
     * @return 列数为colnum的表格
     */
    public static PdfPTable createPdfPTable(int colnum){
        PdfPTable table=new PdfPTable(colnum);
        return table;
    }

    /**
     * 创建表格的单元格
     * @param p 短语
     * @return 单元格
     */
    public static PdfPCell createPdfPCell(Phrase p){
        PdfPCell c = new PdfPCell(p);
        return c;
    }

    /**
     * 功能：创建列表
     * @param numbered  设置为true表明想创建一个进行编号的列表
     * @param lettered 设置为true表示列表采用字母进行编号，为false则用数字进行编号
     * @param symbolIndent listItem的缩进量
     * @return list
     */
    public static List createList(boolean numbered, boolean lettered, float symbolIndent) {
        List list = new List(numbered, lettered, symbolIndent);
        return list;
    }

    /**
     * 功能：创建列表中的项
     * @param content 列表项中的内容
     * @param font 字体格式
     * @return listItem
     */
    public static ListItem createListItem(String content, Font font) {
        ListItem listItem = new ListItem(content, font);
        return listItem;
    }

    /**
     * 创建图像
     * @param image 图像文件
     * @return 图像对象
     */
    public static Image createImage(String image){
        Image im=null;
        try {
            im = Image.getInstance(image);
        } catch (BadElementException ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return im;
    }

    /**
     * 引用链接
     * @param text 内容
     * @param tar 连接到定位符
     * @return 链接
     */
    public static Anchor getAnchor(String text,String tar){
        Anchor anchor = new Anchor(text);
        anchor.setReference("#"+tar);//设置引用
        return anchor;
    }

    /**
     * 将章节写入到指定的PDF文档中
     * @param chapter
     */
    public void writeChapterToDoc(Chapter chapter) {
        try {
            if(document != null) {
                if(!document.isOpen()) document.open();
                document.add(chapter);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 最后关闭PDF文档
     */
    public void closeDocument() {
        if(document != null) {
            document.close();
        }
    }

    public static void main(String args[]){
        String fileName="createPDF.pdf";
        CreatePDF pdf=new CreatePDF();

        Font chapterFont = createChineseFont(20, Font.BOLD, new BaseColor(0, 0, 255));//文章标题字体
        Font sectionFont = createChineseFont(16, Font.BOLD, new BaseColor(0, 0, 255));//文章小节字体
        Font textFont = createChineseFont(10, Font.NORMAL, new BaseColor(0, 0, 0));//小节内容字体

        pdf.createDocument(fileName);//打开文档

        //创建章节
        Chapter chapter = createChapter("章1", 1, 1, 0, chapterFont);
        Section section1 = createSection(chapter, "节1.1", sectionFont,0);
        Phrase text1 = createPhrase("Hello,欢迎使用iText",textFont);
        section1.add(text1);
        //创建定位符
        Anchor anchor1=setAnchor("This is an anchor","Back to Top");
        Paragraph paragraph1=createParagraph("这是一段段落",sectionFont);
        paragraph1.add(anchor1);
        section1.add(paragraph1);

        Section section2 = createSection(chapter, "节1.2", sectionFont,0);
        Phrase text2 = createPhrase("列表：",textFont);
        text2.setLeading(20); //上边距
        section2.add(text2);

        //创建列表
        List list = createList(true, false, 20);
        String tmp = "文档是 PDF 文档的所有元素的容器";
        ListItem listItem1 = createListItem(tmp,textFont);
        ListItem listItem2 = createListItem("列表2",textFont);
        list.add(listItem1);
        list.add(listItem2);
        //创建图像
//        Image i=createImage("D:\\springboot-collections\\springboot-pdf\\平凡之路.jpg");
//        list.add(i);
//        section2.add(list);

        Section section3 = createSection(chapter, "节1.3", sectionFont,0);
        Phrase text3 = createPhrase("表格：",textFont);
        section3.add(text3);

        //创建表格
        PdfPTable table=createPdfPTable(3);
//        table.addCell(i);
        table.addCell(text3);
        table.addCell("列3");
        table.addCell(text2);

        Section section4 = createSection(chapter, "节1.4", sectionFont,0);
        Phrase text4 = createPhrase("定位符：",textFont);
        section4.add(text4);
        //引用定位符
        Anchor anchor2=getAnchor("Back to Top","Back to Top");
        section4.add(anchor2);

        //写入一整章内容
        pdf.writeChapterToDoc(chapter);

        //关闭文档
        pdf.closeDocument();
    }
}
package com.example.poi.controller;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.poi.pojo.ExcelPropertyIndexModel;
import com.example.poi.pojo.MultiLineHeadExcelModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping(value="/writeExcel")
public class WriteExcelController {


    @GetMapping(value="/exportWithoutHead")
    public void  exportWithoutHead()throws IOException {
        ExcelWriter excelWriter =null;
        String file="D:"+File.separator+"springboot-collections"+File.separator+"springboot-poi"+File.separator+"down";
        File filePath=new File(file);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(filePath+"withoutHead.xlsx");//输出字节流
        /**
         * 参数1:需要输出的neirong ,输出的字节流
         * 参数2：输出的样式  两种枚举类型： xlsx、xls
         * 参数3：是否有表头
         */
        excelWriter = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
        Sheet sheet = new Sheet(1, 0);//创建一个sheet
        Sheet sheet1 = new Sheet(2, 1);
        sheet.setSheetName("测试sheet名称");
        sheet1.setSheetName("测试sheet1名称");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0"+i);
            item.add("item1"+i);
            item.add("item2"+i);
            item.add("item3"+i);
            lists.add(item);
        }
        excelWriter.write0(lists,sheet);//写入
        excelWriter.write0(lists,sheet1);

        excelWriter.finish();

    }

    /***
     * 带有表头的Excel
     *
     */
    @GetMapping(value="exportHeadExcel")
    public void exportHeadExcel()throws IOException{

        ExcelWriter writers =null;
        String file="D:"+File.separator+"springboot-collections"+File.separator+"springboot-poi"+File.separator+"down"+File.separator;
        File filePath=new File(file);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file + "exportHeadExcel.xlsx");//输出字节流
        /**
         * 参数1:需要输出的neirong ,输出的字节流
         * 参数2：输出的样式  两种枚举类型： xlsx、xls
         * 参数3：是否有表头
         */
        writers = new ExcelWriter(fileOutputStream, ExcelTypeEnum.XLSX, false);
        Sheet sheet0 = new Sheet(1, 0);//创建一个sheet
        sheet0.setSheetName("测试sheet0名称");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<>();
            item.add("item00"+i);
            item.add("item01"+i);
            item.add("item02"+i);
            item.add("item03"+i);
            lists.add(item);
        }

        /**
         * 添加excel 的表头
         */

        List<List<String>> listHead=new ArrayList<>();
        List<String> head0=new ArrayList<>();
        List<String> head1=new ArrayList<>();
        List<String> head2=new ArrayList<>();
        List<String> head3=new ArrayList<>();
        head0.add("第一列");
        head1.add("第二列");
        head2.add("第三列");
        head3.add("第四列");
        listHead.add(head0);
        listHead.add(head1);
        listHead.add(head2);
        listHead.add(head3);
        Table table = new Table(1);
        table.setHead(listHead);

        writers.write0(lists,sheet0,table);//写入

        writers.finish();


    }

    /**
     * 使用实体类为导出的excel 添加表头
     *
     */
    @GetMapping(value="/exportHeadExcelForPojo")
    public void exportHeadExcelForPojo() throws IOException{
        String file="D:"+File.separator+"springboot-collections"+File.separator+"springboot-poi"+File.separator+"down"+File.separator;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file + "exportHeadExcelForPojo.xlsx");) {
            ExcelWriter writer = new ExcelWriter(fileOutputStream, ExcelTypeEnum.XLSX);

            /**
             * 添加表头有两种范式
             *  方式1：
             *      使用实体类中的注解的值
             *      使用Sheet的构造器  Sheet(int sheetNo, int headLineMun, Class<? extends BaseRowModel> clazz)
             *  方式2：
             *      使用sheet的第二种构造方法
             *      Sheet(int sheetNo, int headLineMun, Class<? extends BaseRowModel> clazz, String sheetName, List<List<String>> head)
             *
             */

            /*List<List<String>> listHead=new ArrayList<>();
            List<String> head0=new ArrayList<>();
            List<String> head1=new ArrayList<>();
            List<String> head2=new ArrayList<>();
            List<String> head3=new ArrayList<>();
            List<String> head4=new ArrayList<>();
            List<String> head5=new ArrayList<>();
            List<String> head6=new ArrayList<>();
            head0.add("第一列");
            head1.add("第二列");
            head2.add("第三列");
            head3.add("第四列");
            head4.add("第五列");
            head5.add("第六列");
            head6.add("第七列");
            listHead.add(head0);
            listHead.add(head1);
            listHead.add(head2);
            listHead.add(head3);
            listHead.add(head4);
            listHead.add(head5);
            listHead.add(head6);*/

//            Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class,"使用构造方法添加sheet",listHead);
            Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
            sheet1.setSheetName("sheet1");
            List<ExcelPropertyIndexModel> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
                item.setName("name" + i);
                item.setAge("age" + i);
                item.setEmail("email" + i);
                item.setAddress("address" + i);
                item.setSax("sax" + i);
                item.setHeigh("heigh" + i);
                item.setLast("last" + i);
                data.add(item);
            }
            writer.write(data, sheet1);
            writer.finish();
        }

    }

    /***
     * 复杂表头
     * @throws IOException
     */
    @GetMapping(value="/writeWithMultiHead")
    public void writeWithMultiHead() throws IOException {
        String file="D:"+File.separator+"springboot-collections"+File.separator+"springboot-poi"+File.separator+"down"+File.separator;
        try (FileOutputStream out = new FileOutputStream(file + "withMultiHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, MultiLineHeadExcelModel.class);
            sheet1.setSheetName("sheet1");
            List<MultiLineHeadExcelModel> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
                item.setP1("p1" + i);
                item.setP2("p2" + i);
                item.setP3("p3" + i);
                item.setP4("p4" + i);
                item.setP5("p5" + i);
                item.setP6("p6" + i);
                item.setP7("p7" + i);
                item.setP8("p8" + i);
                item.setP9("p9" + i);
                data.add(item);
            }
            writer.write(data, sheet1);
            writer.finish();
        }
    }

}

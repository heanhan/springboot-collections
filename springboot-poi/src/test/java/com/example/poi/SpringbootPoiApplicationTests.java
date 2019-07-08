package com.example.poi;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootPoiApplicationTests {

    @Test
    public void contextLoads() {
    }

    /***
     * 测试Easy-Excel 读写
     *
     */
    @Test
    public void  writeWithoutHead()throws IOException {
        ExcelWriter excelWriter =null;
            FileOutputStream out = new FileOutputStream("withoutHead.xlsx");//输出字节流
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

}

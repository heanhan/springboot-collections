package com.example.poi.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author : zhaojh
 * @date : 2019-08-11
 * @function : 通过poi 方式读取excel
 */

@Slf4j
public class PoiReadExcelUtil {

    /**
     * 读取某一个位置下的excel文件
     * @param filePath  读取的文件路径
     *                  File filePath =new File("xxx");
     */
    public static List<Map<String,List<String>>> readExel(File filePath){
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(filePath));//读取excel,得到workbook;

            Map<String,List<String>> mpaSheet = new HashMap<>();//存放sheet集合

            Iterator<Sheet> iterator = workbook.iterator();//得到所有的sheet;
            while(iterator.hasNext()){
                //遍历每一个sheet
                Sheet sheet = iterator.next();
                String sheetName = sheet.getSheetName();//获取当前sheet的name
                List<String> perSheetList = new ArrayList<>();//存放每个sheet的值
                for (int i = 0; i <sheet.getLastRowNum() ; i++) {
                    Row row = sheet.getRow(i);
                    short lastCellNum = row.getLastCellNum();//获取当前一行的最后一列的索引

                    for (int j = 0; j <lastCellNum ; j++) {
                        Cell cell = row.getCell(j);
                        String stringCellValue = cell.getStringCellValue();//获取每一列的值
                        perSheetList.add(stringCellValue);
                        log.info("获取当前列的值");
                    }
                }
                mpaSheet.put(sheetName,perSheetList);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }

}

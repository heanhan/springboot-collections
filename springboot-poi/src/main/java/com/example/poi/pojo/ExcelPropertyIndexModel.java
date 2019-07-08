package com.example.poi.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * 使用实体类为Excle 添加表头
 * 要点集成一个抽象类 BaseRowModel
 *
 * 在每个属性上添加一个注解  @ExcelProperty
 *                      参数value显示的表头的描述
 *                      参数index 表示该属性的索引位置
 */
@Data
public class ExcelPropertyIndexModel extends BaseRowModel {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "年龄", index = 1)
    private String age;

    @ExcelProperty(value = "邮箱", index = 2)
    private String email;

    @ExcelProperty(value = "地址", index = 3)
    private String address;

    @ExcelProperty(value = "性别", index = 4)
    private String sax;

    @ExcelProperty(value = "高度", index = 5)
    private String heigh;

    @ExcelProperty(value = "备注", index = 6)
    private String last;

}

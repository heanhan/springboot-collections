package com.example.poi.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class PartyMember implements Serializable {

    @Excel(name="姓名",orderNum = "1")
    @NotNull(message = "姓名不能为空！")
    private String name;

    @Excel(name = "身份证号",orderNum = "2")
    private String idCard;

    @Excel(name = "入党时间",orderNum = "3",format = "yyyt-MM-dd")
    private Date joinPartyTime;

    @Excel(name="党支部",orderNum = "4")
    private String partyBranch;

    @Excel(name="党员状态",orderNum = "5",replace = {"在职_1","离职_2"},isImportField = "true")
    private String state;
}

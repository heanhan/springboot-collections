package com.example.mybatis.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-12-16
 * @function :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRecord {

    private int id;//id

    private int userId;//用户的id

    private String bookName;//图书名称

    private Date createTime;//创建时间

    private String category;//类别

    private int reordNum;//借阅次数
}

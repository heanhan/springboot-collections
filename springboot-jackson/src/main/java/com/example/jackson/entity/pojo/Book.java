package com.example.jackson.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{
    private String id;//书id
    private String name;//书名
    private String[] category;//分类
    private double price;//价格
    private String author;//作者
    private Date publishTime;//发行日期
}

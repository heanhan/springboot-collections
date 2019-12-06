package com.example.mybatis.entity.pojo;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 班级实体类
 */
@Data
@Slf4j
public class Grade {

    private String  gid;//班级id
    private String  period;//届
    private String gName;//班级名
    private int gsort;//排名
    private List<Student> studentList;//学生组成

}

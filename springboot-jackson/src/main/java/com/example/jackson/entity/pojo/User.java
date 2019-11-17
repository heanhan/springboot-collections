package com.example.jackson.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private String userName;//用户名

    private int age;//年龄

    private String password;//密码

    private Date birthday;//生日

    private String[] hobby;//爱好

    private List<String> roles;//角色

    private List<Book> books;//拥有的书籍

    private Map<String,String>  course;//所选课程

    private Map<String,List<Teacher>> courseTeacher;//课程的授课老师
}

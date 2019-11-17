package com.example.jackson.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {

    private String id;//教师id
    private String name;//教师姓名
    private String TeachCourse;//所带的课程
}

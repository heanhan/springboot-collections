package com.example.mybatis.service;

import com.example.mybatis.pojo.Student;

import java.util.List;

public interface IStudentService {

    /**
     * 添加学生
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 查询所有的学生
     * @return
     */
    List<Student> findAllStudent();


    /**
     * 动态条件查询学生
     * @param stuId
     * @param stuName
     * @param sex
     * @param telphone
     * @return
     */
    List<Student> findStudentByCondition(String stuId, String stuName, String sex, String telphone);
}

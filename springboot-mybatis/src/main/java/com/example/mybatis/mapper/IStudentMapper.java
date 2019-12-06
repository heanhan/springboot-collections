package com.example.mybatis.mapper;

import com.example.mybatis.entity.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStudentMapper {

    /**
     * 添加学生
     *
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

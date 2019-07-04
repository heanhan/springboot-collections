package com.example.mybatis.service.impl;

import com.example.mybatis.mapper.IStudentMapper;
import com.example.mybatis.pojo.Student;
import com.example.mybatis.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentMapper studentMapper;
    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    /**
     * 查询所有的学生
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }

    /**
     * 动态条件查询学生
     * @param stuId
     * @param stuName
     * @param sex
     * @param telphone
     * @return
     */
    public List<Student> findStudentByCondition(String stuId,String stuName,String sex,String telphone)
    {
        return studentMapper.findStudentByCondition(stuId,stuName,sex,telphone);
    }


}

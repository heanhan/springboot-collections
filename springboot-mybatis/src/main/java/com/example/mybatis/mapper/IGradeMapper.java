package com.example.mybatis.mapper;

import com.example.mybatis.entity.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGradeMapper {

    /**
     * 添加班级
     * @param grade
     * @return
     */
    int addGrade(Grade grade);

    /**
     * 查询班级的学生
     * @param gid
     * @return
     */
    List<Grade> findGradeOfStudent(String gid);

}

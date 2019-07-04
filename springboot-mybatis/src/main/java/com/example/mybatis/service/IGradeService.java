package com.example.mybatis.service;


import com.example.mybatis.pojo.Grade;

import java.util.List;

public interface IGradeService {


    /**
     * 添加班级
     * @param grade
     * @return
     */
    public int addGrade(Grade grade);

    /**
     * 查询班级的学生
     * @param gid
     * @return
     */
    public List<Grade> findGradeOfStudent(String gid);
}

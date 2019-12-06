package com.example.mybatis.service.impl;

import com.example.mybatis.mapper.IGradeMapper;
import com.example.mybatis.entity.pojo.Grade;
import com.example.mybatis.service.IGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Resource
    private IGradeMapper gradeMapper;

    /**
     * 添加学生
     * @param grade
     * @return
     */
    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.addGrade(grade);
    }

    /**
     * 查询班级的学生
     * @param gid
     * @return
     */
    public List<Grade> findGradeOfStudent(String gid){
        return gradeMapper.findGradeOfStudent(gid);
    }
}

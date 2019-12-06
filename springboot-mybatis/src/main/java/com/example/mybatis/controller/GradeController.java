package com.example.mybatis.controller;

import com.example.common.model.Result;
import com.example.common.model.StatusCode;
import com.example.common.utils.IdWorker;
import com.example.mybatis.entity.pojo.Grade;
import com.example.mybatis.service.IGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping(value="/grade")
public class GradeController {
    private int i=-1;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IGradeService iGradeService;

    @PostMapping(value="/AddGrade")
    @ApiOperation(value = "接口名称:添加班级 ", notes = "接口的详细说明")
    public Result AddGrade(Grade grade){

        grade.setGid(idWorker.nextId()+"");
        int i = iGradeService.addGrade(grade);
        if(i>0){
            return new Result(true, StatusCode.OK,"添加班级成功");
        }
        return new Result(false, StatusCode.ERROR,"添加班级失败");
    }

    /**
     * 查询班级有多少学生
     */

    @PostMapping(value="/findGradeOfStudent/{gid}")
    @ApiOperation(value = "接口名称：查询班级的学生", notes = "接口的详细说明")
    public Result findGradeOfStudent(@PathVariable String gid)
    {

        List<Grade> gradeOfStudent = iGradeService.findGradeOfStudent(gid);
        return new Result(true,StatusCode.OK,"查询成功",gradeOfStudent);
    }



}

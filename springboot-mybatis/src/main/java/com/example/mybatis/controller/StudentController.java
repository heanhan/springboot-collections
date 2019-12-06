package com.example.mybatis.controller;

import com.example.common.model.Result;
import com.example.common.model.StatusCode;
import com.example.common.utils.IdWorker;
import com.example.mybatis.entity.pojo.Student;
import com.example.mybatis.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value="/student")
public class StudentController {

    private int i=-1;//标识开关

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IStudentService studentService;

    /**
     * 添加学生
     */
    @PostMapping(value="/addStudent")
    @ApiOperation(value = "接口名称:添加学生     ", notes = "接口的详细说明")
    public Result addStudent(Student student){
        student.setStuId(idWorker.nextId()+"");//添加主键
        i=studentService.addStudent(student);
        if(i>0)
        {
            return new Result(true, StatusCode.OK,"添加成功");
        }
        return new Result(false,StatusCode.ERROR,"添加失败");

    }

    /**
     * 查询所有的学生的列表带分页
     * pageNum  当前页
     * pageSize  每页大小
     * @return
     */
    @GetMapping(value="/findAllStudent")
    public Result findAllStudent(){

        List<Student> allStudent = studentService.findAllStudent();
        return new Result(true,StatusCode.OK,"查询成功",allStudent);
    }

    /**
     * 查询所有的学生的列表带分页
     * pageNum  当前页
     * pageSize  每页大小
     * @return
     */
    @GetMapping(value="/findAllStudentAndPage/{pageNum}/{pageSize}")
    public Result findAllStudentAndPage(@PathVariable int pageNum, @PathVariable int pageSize){

        //使用PagerHelper插件分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student> allStudent = studentService.findAllStudent();
        PageInfo<Student> pageInfo=new PageInfo<>(allStudent);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    //动态条件模糊查询学生
    @PostMapping(value="/findStudentByCondition")
    public Result findStudentByCondition(String stuId,String stuName,String sex,String telphone)
    {

        List<Student> studentByCondition = studentService.findStudentByCondition(stuId, stuName, sex, telphone);
        return new Result(true,StatusCode.OK,"查询成功",studentByCondition);
    }



}

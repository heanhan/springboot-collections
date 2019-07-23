package com.example.jpa.controller;

import com.example.common.model.Result;
import com.example.common.model.StatusCode;
import com.example.jpa.pojo.Employee;
import com.example.jpa.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@RestController
@RequestMapping(value="/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/findByEmployeeOfProjectInfo")
    public Result  findByEmployeeOfProjectInfo(String employeeId){

        Employee employeeOfProjectInfo = employeeService.findByEmployeeOfProjectInfo(Integer.parseInt(employeeId));
        log.info("输出雇员信息："+employeeOfProjectInfo);
        log.info("输出雇员信息："+employeeOfProjectInfo);
        return new Result(false,StatusCode.OK,"success !",employeeOfProjectInfo);
    }



}

package com.example.jpa.controller;

import com.example.jpa.model.EmployeeProjectInner;
import com.example.jpa.pojo.Employee;
import com.example.jpa.service.EmployeeProjectInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Controller
public class EmployeeProjectInnerController {

    @Autowired
    private EmployeeProjectInnerService employeeProjectInnerService;


    @RequestMapping(value="/findByEmployeeProjectInnerPage",method = RequestMethod.GET)
    public Page<Employee> findByEmployeeProjectInnerPage(String eid){
        int pageNum=1;
        int pageSize=5;

        Page<Employee> byEmployeeProjectInnerPage = employeeProjectInnerService.findByEmployeeProjectInnerPage(eid, pageNum, pageSize);
        return byEmployeeProjectInnerPage;

    }


}

package com.example.jpa.service;

import com.example.jpa.model.EmployeeProjectInner;
import com.example.jpa.pojo.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeProjectInnerService {


    /**
     *
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @return Page
     */
    Page<Employee>findByEmployeeProjectInnerPage(String eid, int pageNum, int pageSize);


}

package com.example.jpa.service;

import com.example.jpa.pojo.Employee;

public interface EmployeeService {


    /**
     * 查询Employee下的所有的信息
     * @param employeeId    employee的id
     * @return  Employee
     */
    Employee findByEmployeeOfProjectInfo(int employeeId);


}

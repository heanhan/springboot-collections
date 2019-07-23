package com.example.jpa.service.impl;

import com.example.jpa.dao.EmployeeDao;
import com.example.jpa.pojo.Employee;
import com.example.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询Employee下的所有的信息
     * @param employeeId    employee的id
     * @return  Employee
     */
    @Override
    public Employee findByEmployeeOfProjectInfo(int employeeId){

        return employeeDao.findByEmployeeOfProjectInfo(employeeId);
    }
}

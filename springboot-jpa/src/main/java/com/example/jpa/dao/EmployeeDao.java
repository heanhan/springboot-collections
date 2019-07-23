package com.example.jpa.dao;

import com.example.jpa.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee> {


    @Query(value="select * from employee where id= ?1 ",nativeQuery = true)
    Employee findByEmployeeOfProjectInfo(int employeeId);
}

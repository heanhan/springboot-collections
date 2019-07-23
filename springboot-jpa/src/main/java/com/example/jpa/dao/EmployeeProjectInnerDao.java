package com.example.jpa.dao;

import com.example.jpa.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectInnerDao extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee> {
}

package com.example.jpa.service.impl;

import com.example.jpa.dao.EmployeeProjectInnerDao;
import com.example.jpa.pojo.Employee;
import com.example.jpa.service.EmployeeProjectInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Service
public class EmployeeProjectInnerServiceImpl implements EmployeeProjectInnerService {

    @Autowired
    private EmployeeProjectInnerDao employeeProjectInnerDao;

    /**
     *
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @return Page
     */
    @Override
    public Page<Employee> findByEmployeeProjectInnerPage(String eid, int pageNum, int pageSize){


        PageRequest pageRequest=PageRequest.of(pageNum-1,pageSize);//封装分页数据

        Specification<Employee> prdc=new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> employeeId = root.get("id");
                Predicate predicate = criteriaBuilder.equal(employeeId.as(Integer.class), eid);
                return predicate;
            }
        };
        return employeeProjectInnerDao.findAll(prdc,pageRequest);
    }
}

package com.example.jpa.dao;

import com.example.jpa.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDao extends JpaRepository<Grade,Integer>, JpaSpecificationExecutor<Grade> {
}

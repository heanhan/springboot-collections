package com.example.jpa.dao;

import com.example.jpa.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
}

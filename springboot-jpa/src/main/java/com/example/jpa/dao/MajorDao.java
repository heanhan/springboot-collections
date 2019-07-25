package com.example.jpa.dao;

import com.example.jpa.pojo.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorDao extends JpaRepository<Major,Integer>, JpaSpecificationExecutor<Major> {
}

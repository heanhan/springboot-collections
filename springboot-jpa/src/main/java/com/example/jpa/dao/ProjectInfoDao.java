package com.example.jpa.dao;

import com.example.jpa.pojo.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInfoDao extends JpaRepository<ProjectInfo,Integer> , JpaSpecificationExecutor<ProjectInfo> {
}

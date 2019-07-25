package com.example.swagger.dao;

import com.example.swagger.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

}

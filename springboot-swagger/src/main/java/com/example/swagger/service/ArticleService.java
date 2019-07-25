package com.example.swagger.service;

import com.example.swagger.pojo.Article;

import java.util.List;

public interface ArticleService {


    /**
     * 添加文章
     * @param article  文章
     * @return  Article
     */
    Article addArticle(Article article);

    /**
     * 添加  批量文章
     *
     * @param article 文章
     * @return Article
     */
    List<Article> addArticle(List<Article> article);

    /**
     * 删除文章 根据id
     * @param articleId  id
     */
    void removeArticleById(String articleId);


    /**
     * 查询   根据id
     * @param articleId id
     * @return article
     */
    Article findArticleById(String articleId);

    /**
     * 查询文章  全部
     * @return List<Article>
     */
    List<Article> findAllArticleList();
}

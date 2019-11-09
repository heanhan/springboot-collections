package com.example.mongodb.service;

import com.example.mongodb.pojo.Article;

import java.util.List;

public interface IArticleService {

    /**
     * 批量添加添加翁张
     * @param articleList  文章集合
     * @return  返回添加成功后的文章集合
     */
    List<Article> addArticle(List<Article> articleList);

    /**
     * 添加单个文章
     * @param article 文章
     * @return 文章信息
     */
    Article addArticleInfo(Article article);
}

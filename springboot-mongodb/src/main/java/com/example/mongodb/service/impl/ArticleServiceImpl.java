package com.example.mongodb.service.impl;

import com.example.mongodb.pojo.Article;
import com.example.mongodb.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function :
 */

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 批量添加添加翁张
     * @param articleList  文章集合
     * @return  返回添加成功后的文章集合
     */
    @Override
    public List<Article> addArticle(List<Article> articleList){
        List<Article> save = (List<Article>) mongoTemplate.insert(articleList,Article.class);
        return save;
    }

    /**
     * 添加单个文章
     * @param article 文章
     * @return 文章信息
     */
    @Override
    public Article addArticleInfo(Article article){
        return mongoTemplate.save(article);
    }
}

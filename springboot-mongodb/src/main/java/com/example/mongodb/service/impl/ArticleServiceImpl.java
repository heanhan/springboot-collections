package com.example.mongodb.service.impl;

import com.example.mongodb.pojo.Article;
import com.example.mongodb.service.IArticleService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 修改第一条数据author 为 zhaojh0912 的数据title 和visitCount
     * @param author 作者
     * @param title 标题
     * @param visitCount 浏览数
     * @return 文章信息
     */
    @Override
    @Transactional
    public UpdateResult modifyFirstArticleInfo(String author, String title, int visitCount){
        Query query = Query.query(Criteria.where("author").is("zhaojh0912"));
        Update update = Update.update("title", title).set("visitCount", visitCount);
        return mongoTemplate.updateFirst(query,update,Article.class);
    }
}

package com.example.swagger.service.impl;

import com.example.swagger.dao.ArticleDao;
import com.example.swagger.pojo.Article;
import com.example.swagger.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-25
 * @function :
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    /**
     * 添加文章
     *
     * @param article 文章
     * @return Article
     */
    @Override
    public Article addArticle(Article article) {
        return articleDao.save(article);


    }

    /**
     * 添加  批量文章
     *
     * @param article 文章
     * @return Article
     */
    @Override
    public List<Article> addArticle(List<Article> article) {
        return articleDao.saveAll(article);

    }

    /**
     * 删除文章 根据id
     *
     * @param articleId id
     */
    @Override
    public void removeArticleById(String articleId) {
        articleDao.deleteById(articleId);

    }


    /**
     * 查询   根据id
     *
     * @param articleId id
     * @return article
     */
    @Override
    public Article findArticleById(String articleId) {
        return articleDao.getOne(articleId);

    }

    /**
     * 查询文章  全部
     *
     * @return List<Article>
     */
    @Override
    public List<Article> findAllArticleList() {
        return articleDao.findAll();

    }
}

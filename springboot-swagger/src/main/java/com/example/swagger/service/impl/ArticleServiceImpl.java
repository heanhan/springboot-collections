package com.example.swagger.service.impl;

import com.example.swagger.dao.ArticleDao;
import com.example.swagger.pojo.Article;
import com.example.swagger.service.ArticleService;
import com.example.swagger.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : zhaojh
 * @date : 2019-07-25
 * @function :
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 添加文章
     *
     * @param article 文章
     * @return Article
     */
    @Override
    public Article addArticle(Article article) {
        Article save = articleDao.save(article);
        if(save.getArticleId()!=null){
            //将article 存放到redis中
            redisUtil.set(save.getArticleId(),save,10);
        }
        return save;


    }

    /**
     * 添加  批量文章
     *
     * @param article 文章
     * @return Article
     */
    @Override
    public List<Article> addArticle(List<Article> article) {
        List<Article> articleList = articleDao.saveAll(article);
        //将数据存放到redis中
        if(articleList.size()>0){
            articleList.stream().forEach(
                    article1->redisUtil.set(article1.getArticleId(),article1,10)
            );
        }
        return articleDao.saveAll(article);

    }

    /**
     * 删除文章 根据id
     *
     * @param articleId id
     */
    @Override
    public void removeArticleById(String articleId) {

        //先判断redis中是否存在数据
        if(redisUtil.get(articleId)!=null){
            redisUtil.del(articleId);
        }
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
        //先判断redis 中是否存在
        if(redisUtil.get("articleId")!=null){
            Article articleId1 =(Article) redisUtil.get("articleId");
            return articleId1;
        }
        Optional<Article> article = articleDao.findById(articleId);
        Article article1 = article.orElse(null);
        redisUtil.set(article1.getArticleId(),article1,10);
        return article1;

    }

    /**
     * 查询文章  全部
     *
     * @return List<Article>
     */
    @Override
    public List<Article> findAllArticleList() {
        if(redisUtil.get("findAllArticleList")!=null)
        {
            List<Article> findAllArticleList =(List<Article>) redisUtil.get("findAllArticleList");
            return findAllArticleList;
        }
        List<Article> all = articleDao.findAll();
        redisUtil.set("findAllArticleList",all,10);
        return all;

    }
}

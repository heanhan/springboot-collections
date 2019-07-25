package com.example.swagger.controller;

import com.example.common.utils.IdWorker;
import com.example.swagger.pojo.Article;
import com.example.swagger.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-25
 * @function : 文章的控制器
 */

@Api(value = "文章相关的接口")
@RestController
@RequestMapping(value = "/swagger")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private IdWorker idWorker;


    /**
     * 添加文章
     *
     * @param article 文章
     * @return Article
     */
    @PostMapping(value = "/addArticle")
    @ApiOperation(value = "添加文章", notes = "添加文章，传递的参数是实体")
    public String addArticle(Article article) {

        Article article1 = articleService.addArticle(article);
        return "添加成功！";

    }


    /**
     * 添加  批量文章
     */

    @PostMapping(value = "/addArticleBeatch")
    @ApiOperation(value = "添加文章", notes = "添加  批量文章")
    public List<Article> addArticleBeatch(/*Article article*/) {
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setArticleId(idWorker.nextId() + "");//主键
            article.setArticleTitle("文章Article" + i);//标题
            article.setArticleContent("这是一段文章的内容......" + i);
            article.setAuthor("作者Author" + i);
            article.setCreateTime(new Date());//创建时间
            articleList.add(article);

        }
        List<Article> articleList1 = articleService.addArticle(articleList);
        return articleList1;

    }


    /**
     * 删除文章 根据id
     *
     * @param articleId id
     */
    @DeleteMapping(value = "/removeArticleById")
    @ApiOperation(value = "删除文章", notes = "删除文章，传递的参数是id")
    public String removeArticleById(String articleId) {
        articleService.removeArticleById(articleId);
        return "删除成功！";
    }


    /**
     * 查询   根据id
     * @param articleId id
     * @return article
     */
    @GetMapping(value="/findByArticleId")
    @ApiOperation(value = "查询文章信息 ", notes = "查询   根据id")
    public Article findByArticleId(String articleId) {
        Article article = articleService.findArticleById(articleId);
        return article;
    }


    /**
     * 查询文章  全部
     * @return List<Article>
     */
    @GetMapping(value = "")
    @ApiOperation(value = "查询文章", notes = "查询文章,没有分页")
    public List<Article> findAllArticle(){
        List<Article> allArticleList = articleService.findAllArticleList();

        return allArticleList;
    }

}

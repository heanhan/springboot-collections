package com.example.mongodb.controller;

import com.example.mongodb.pojo.Article;
import com.example.mongodb.service.IArticleService;
import com.example.mongodb.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function :
 */

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IArticleService articleService;


    /**
     * 批量添加 文章
     * @return
     */
    @PostMapping(value = "/addArticleList")
    public String AddArticle(){

        List<Article> articleList = new ArrayList<>();
        Article article= null;
        for (int i = 0; i < 50; i++) {
            article= new Article();
            article.setId(idWorker.nextId()+"");//主键
            article.setTitle("个人随记第"+i+"天");//标题
            article.setUrl("http://localhost:8080/article/个人随记"+i);//url地址
            article.setAuthor("zhaojh0912");//作者
            ArrayList<String> tagList = new ArrayList<>();
            tagList.add(0,"个人生活");
            tagList.add(1,"心情随记");
            tagList.add(2,"个人生活");
            article.setTags(tagList);//添加标签
            article.setCreateTime(new Date());//创建时间
            articleList.add(article);
        }
        List<Article> articles = articleService.addArticle(articleList);
        if(articles.size()>0){
            return "add article list is success !";
        }
        return "add article list is fail !";
    }

    @PostMapping(value = "/addArticleInfo")
    public String addArticleInfo(@RequestBody  Article article){
        Article article1 = articleService.addArticleInfo(article);
        if(article1.getId()!=null){
            return "add article one is success";
        }
        return "add article one is fail";
    }


}

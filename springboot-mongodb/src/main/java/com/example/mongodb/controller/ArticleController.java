package com.example.mongodb.controller;

import com.example.mongodb.pojo.Article;
import com.example.mongodb.service.IArticleService;
import com.example.mongodb.utils.IdWorker;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加单个文章
     * @param article 文章
     * @return success/fail
     */
    @PostMapping(value = "/addArticleInfo")
    public String addArticleInfo(@RequestBody  Article article){
        Article article1 = articleService.addArticleInfo(article);
        if(article1.getId()!=null){
            return "add article one is success";
        }
        return "add article one is fail";
    }

    /**
     * 修改第一条数据author 为 zhaojh0912 的数据title 和visitCount
     * @param author 作者
     * @param title 标题
     * @param visitCount 浏览数
     * @return UpdateResult
     */
    @PutMapping(value = "/modifyFirstArticleInfo")
    public UpdateResult modifyFirstArticleInfo(String author,String title,int visitCount){

        UpdateResult updateResult = articleService.modifyFirstArticleInfo(author, title, visitCount);
        return updateResult;
    }

    /**
     * 修改符合所遇条件的文章信息   条件：  author=zhaojh0912 的title、visitCount
     * @param author 作者
     * @param title 标题
     * @param visitCount 浏览数
     * @return  UpdateResult
     */
    @PutMapping(value = "/modifyAllArticleInfo")
    public UpdateResult modifyAllArticleInfo(String author,String title,int visitCount){
        UpdateResult updateResult = articleService.modifyAllArticleInfo(author, title, visitCount);
        return updateResult;
    }

    /**
     * 特殊更新 有则更新，没有则添加一条数据
     * @param author 作者
     * @param title 标题
     * @param visitCount 浏览数
     * @return UpdateResult
     */
    @PutMapping(value = "/modifySpecialArticle")
    public UpdateResult modifySpecialArticle(String author,String title,int visitCount){
        return null;
    }


}

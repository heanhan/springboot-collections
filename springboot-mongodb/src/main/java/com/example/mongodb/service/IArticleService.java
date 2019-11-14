package com.example.mongodb.service;

import com.example.mongodb.pojo.Article;
import com.mongodb.client.result.UpdateResult;

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


    /**
     * 修改第一条数据author 为 zhaojh0912 的数据title 和visitCount
     * @param author 作者
     * @param title 标题
     * @param visitCount 浏览数
     * @return 文章信息
     */
    UpdateResult modifyFirstArticleInfo(String author, String title, int visitCount);

    /**
     * 修改符合所遇条件的文章信息   条件：  author=zhaojh0912 的title、visitCount
     * @param author
     * @param title
     * @param visitCount
     * @return
     */
    UpdateResult modifyAllArticleInfo(String author, String title, int visitCount);
}

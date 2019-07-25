package com.example.swagger.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-07-25
 * @function :
 */

@Data
@Entity
@Table(name = "zjh_article")
public class Article {

    @Id
    @Column(name = "article_id")
    private String articleId;

    @Column(name = "article_title")
    private String articleTitle;//标题

    @Column(name = "article_content")
    private String articleContent;//内容

    @Column(name = "author")
    private String author;//作者

    @Column(name = "create_time")
    private Date createTime;//创建时间

    @Column(name = "update_time")
    private Date updateTime;//修改时间

}

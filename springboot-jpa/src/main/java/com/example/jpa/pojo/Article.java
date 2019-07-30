package com.example.jpa.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-07-27
 * @function : article   use  Auditing
 */

@Data
@Entity
@Table(name = "auditing_article")
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @Column(name = "article_id")
    private String articleId;//id

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedBy
    @Column(name = "create_user_id",nullable = true)
    private String createUserId;

    @CreatedDate
    @Column(name = "create_time",nullable = true)
    private Date createTime;

    @LastModifiedBy
    @Column(name = "last_modify_user_id",nullable = true)
    private String lastModifyUserId;

    @LastModifiedDate
    @Column(name = "last_modify_date",nullable = true)
    private String lastModifyDate;

}

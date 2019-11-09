package com.example.mongodb.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function :  使用mongodb 创建对应的实体
 *
 * 实体类中的注解解释：
 *      Document 注解标识这是一个文档，等同mysql中的表，注解里的属性collection 值标识mongodb中的集合(数据库中的表的具体名)名称，不写默认为实体类的名称 首写字母小写。
 *      Id 注解为主键标识，使用的是spring 的注解包下的
 *      Field 注解为字段标识，指定字段的名称，官方文档中的提示技巧：Spring Data Mongo 中有这样的注解，是为了让用户能够自定义字段名称，可以和实体名称不一致，好处可以缩写mongo中变量名长度
 *      节省存储空间，mongo的存储方式是 key value 形式的，每个key都会有重复存储，key其实就占了一大部分空间。
 *
 *
 */

@Data
@Document(collection = "article_info")
public class Article implements Serializable {

    @Id
    @Field(value = "id")
    private String id;//主键

    @Field(value = "title")
    private String title;//标题

    @Field(value = "url")
    private String url;//url链接地址

    @Field(value = "author")
    private String author;//作者

    @Field(value = "tags")
    private List<String> tags;//标签

    @Field(value = "visit_count")
    private Long visitCount;//浏览量

    @Field(value = "create_time")
    private Date createTime;//创建时间

    @Field(value = "update_time")
    private Date updateTime;//更新时间
}

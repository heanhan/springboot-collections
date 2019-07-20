package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @author : zhaojh
 * @date : 2019-05-11
 * @function :  User 类，简单测试使用jpa 的crud,分页，动态条件，排序的
 *
 * 注：@Data 是使用Lombok 插件生成getter、setter、构造方法的等方法。
 *    @Entity   ：该注解 使用的是javax.persistence 下的持久化的注解，被注解的实体可以被持久化映射，配合注解@Table指向数据库中的对应的表
 *    @Table(name = "zjh_user") ：指向数据库中的表
 *             重要的参数：name  映射的表名，
 *                   indexes： 索引信息 ，例如  indexes = arrayOf(Index(name = "idx_category", columnList = "category")
 *
 */

@Data
@Entity
@Table(name = "zjh_user")
public class User {

    /**
     *
     * @Id 表名该字段为主键
     * @Column: 映射数据库表中字段名
     * @GeneratedValue  主键增长策略（strategy）：生成策略有如下集中方式
     *                      1、GenerationType.IDENTITY  ：支持mysql 的主键自增
     *                      2、GenerationType.SEQUENCE  ：序列方式，根据底层数据库的序列来生成主键，条件是数据库支持序列 ,使用 Oracle
     *                      3、GenerationType.TABLE  ：使用一个特定的数据库表格来保存主键。
     *                      4、GenerationType.AUTO  ：主键由程序控制,自动根据数据类型选择主键该数据支持的生成模式
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId; //用户id

    @Column(name = "user_name")
    private String userName;//用户名

    @Column(name = "password")
    private String password;//密码

    @Column(name = "gender")
    private String gender; //用户性别

    /**
     * 数据库中存在数据形式为： 篮球、足球、乒乓球、跑步
     */
    @Column(name="hobby")
    private String hobby; //爱好

    @Column(name="desc_info")
    private String descInfo;//简介

    @Column(name = "create_time")
    private Date createTime;  //用户添加时间

    @Column(name = "update_time")
    private Date updateTime; //用户信息更新时间


}

package com.example.interceptor.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @author : zhaojh
 * @date : 2019-05-11
 * @function :  User 类
 *
 */

@Data
@Entity
@Table(name = "zjh_user")
public class User {

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

    @Column(name="hobby")
    private String hobby; //爱好

    @Column(name="desc_info")
    private String descInfo;//简介

    @Column(name = "create_time")
    private Date createTime;  //用户添加时间

    @Column(name = "update_time")
    private Date updateTime; //用户信息更新时间


}

package com.example.files.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Integer userId;//账号

    @Column(name="nicename")
    private String niceName;//昵称

    @Column(name="username")
    private String userName;//用户名

    @Column(name="password")
    private String password;//密码

    @Column(name="headphoto")
    private String headPhoto;//头像

    @Column(name="photo")
    private String photo;//照片

    @Column(name="description")
    private String description;//简介



}

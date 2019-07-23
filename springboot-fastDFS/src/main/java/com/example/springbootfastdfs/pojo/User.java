package com.example.springbootfastdfs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :  用户信息，主要用于测试保存用户头像
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fastdfs_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;// id

    @Column(name = "password")
    private String password;//密码

    @Column(name = "roles")
    private String roles;//角色

    @Column(name = "head_img")
    private String headImg;//头像

    @Column(name = "telphone")
    private String telphone;//手机通讯

    @Column(name = "address")
    private String address;//地址

    @Column(name = "life_picture")
    private String lifePicture;//生活照

}

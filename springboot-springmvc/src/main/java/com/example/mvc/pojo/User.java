package com.example.mvc.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-09-18
 * @function :
 */

@Component
@Data
@Slf4j
public class User  implements Serializable {

    private Integer userId;//id
    private String userName;//用户名
    private String password;//密码
    private Boolean sex;//性别  男 0，女 1
    private Date birthday;//出生日期
    private String hobby;//爱好
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String discription;//个人介绍

}

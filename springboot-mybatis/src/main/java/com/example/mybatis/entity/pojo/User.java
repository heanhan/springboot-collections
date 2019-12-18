package com.example.mybatis.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhaojh
 * @date : 2019-12-16
 * @function :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int useId;//用户id

    private String userName;//用户名

    private String sex;//性别

    private String descript;//用户介绍
}

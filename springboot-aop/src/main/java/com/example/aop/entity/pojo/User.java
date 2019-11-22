package com.example.aop.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhaojh
 * @date : 2019-11-02
 * @function :
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;//id

    private String name;//姓名

    private  String password;//密码

    private int age;//年龄
}

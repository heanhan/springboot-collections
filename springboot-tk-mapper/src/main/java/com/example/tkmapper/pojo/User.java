package com.example.tkmapper.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhaojh
 * @date : 2019-08-07
 * @function :
 */

@Data
public class User  implements Serializable {

    private int id;//主键
    private String name;//姓名
}

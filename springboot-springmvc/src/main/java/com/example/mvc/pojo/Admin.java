package com.example.mvc.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-10-31
 * @function :
 */

@Data
public class Admin {

    private String id;
    private String name;
    private List<String> hobby;
}

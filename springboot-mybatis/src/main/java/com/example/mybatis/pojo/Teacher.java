package com.example.mybatis.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class Teacher implements Serializable {

    private String tid;//id
    private String tname;
    private String tdescs;


}

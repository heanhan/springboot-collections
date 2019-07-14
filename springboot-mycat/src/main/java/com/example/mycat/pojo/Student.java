package com.example.mycat.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : zhaojh
 * @date : 2019-07-14
 * @function : 学生实体
 */

@Data
@Entity
@Table(name = "mycat_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键id


    @Column(name = "name")
    private String name; //学生姓名
}

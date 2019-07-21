package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : zhaojh
 * @date : 2019-06-20
 * @function :学生类；设定规则
 *              与老师的关系【学生（多）-------->老师（多）】
 *              与专业课的关系【学生-（一）------->专业课（多）】
 */

//@Entity
//@Table(name = "zjh_student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private Integer stuId;  //学生的id

    private String stuName; //姓名

    private String sex; //性别

    private Float height;   //身高

    private String description; //个人简介


}

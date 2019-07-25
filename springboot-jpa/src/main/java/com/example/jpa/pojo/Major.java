package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-06-20
 * @function : 专业课类:设定规则
 * 与学生类关系：【学生（多）--->专业课（多）】
 * 与老师类关系：【老师（多）--->专业课（一）】
 */

@Entity
@Table(name = "zjh_major")
@Data
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Integer majorId;//主键

    @Column(name = "major_name")
    private String majorName;//专业课名称

    @Column(name = "major_descript")
    private String majorDescript;//专业课描述

    @OneToMany(mappedBy = "majorTeacher")
    private List<Teacher> teacher= new ArrayList<>();//任课老师
}

package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-06-20
 * @function :学生类；设定规则
 *              与老师的关系【学生（多）-------->老师（多）】
 *              与专业课的关系【学生-（一）------->专业课（多）】
 */

@Data
@Entity
@Table(name = "zjh_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;  //学生的id

    @Column(name = "sudent_name")
    private String studentName; //姓名

    @Column(name = "student_sex")
    private String studentSex; //性别

    @Column(name = "description_height")
    private Float studentHeight;   //身高

    @Column(name = "student_description")
    private String studentDescription; //个人简介

    @ManyToOne
    @JoinColumn(name ="student_grade_id" )
    private Grade gradeToStudent;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="student_teacher_inner", //中间表名
            //中间表字段
            joinColumns={@JoinColumn(name="inner_student_id",referencedColumnName="student_id")},
            inverseJoinColumns={@JoinColumn(name="inner_teacher_id",referencedColumnName="teacher_id")}
    )
    private List<Teacher> teachers;//老师


}

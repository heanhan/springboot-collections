package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-24
 * @function : 班级
 */


@Data
@Entity
@Table(name = "zjh_grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grade_id")
    private Integer gradeId;//主键

    @Column(name="grade_name")
    private String gradeName;//班级名

    @Column(name="grade_year")
    private String gradeYear;//年级

    @OneToMany(mappedBy = "gradeToStudent" )
    private List<Student> students;//学生

    @OneToMany(mappedBy = "gradesToTeacher")
    private List<Teacher> teachers;//任课老师
}

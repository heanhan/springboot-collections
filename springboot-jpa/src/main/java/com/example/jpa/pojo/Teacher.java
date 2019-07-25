package com.example.jpa.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-06-20
 * @function :老师类；设定规则
 *                  与学生类的关系，【老师（多）-------->学生（多）】
 *                  与专业课的关系，【老师（一）-------->专业课（一）】
 */

@Data
@Entity
@Table(name= "zjh_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;//主键

    @Column(name = "teacher_name")
    private String teacherName;//教师姓名

    @Column(name = "teacher_sex")
    private String teacherSex;//性别

    @Column(name = "teacher_age")
    private int teacherAge;//年龄

    @ManyToOne
    //@JoinColumn: 维护外键
    @JoinColumn(name = "teacher_grade_id")   //教师与班级的关系是：  多对一
    private Grade gradesToTeacher;//班级

    @ManyToOne
    @JoinColumn(name = "teacher_major_id")
    private Major majorTeacher;  //专业课， 多对一

    @ManyToMany(mappedBy = "teachers",fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)   //NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    private List<Student> students;

}

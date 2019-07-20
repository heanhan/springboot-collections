package com.example.jpa.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : zhaojh
 * @date : 2019-06-20
 * @function :老师类；设定规则
 *                  与学生类的关系，【老师（多）-------->学生（多）】
 *                  与专业课的关系，【老师（一）-------->专业课（一）】
 */

@Entity
@Table(name= "zjh_teacher")
public class Teacher {
}

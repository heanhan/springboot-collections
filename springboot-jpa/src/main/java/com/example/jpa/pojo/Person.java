package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

//@Data
//@Entity
//@Table(name = "zhao_person")
public class Person implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "person_id")
//    private Integer id;
//
//    @Column(name = "person_name")
//    private String personName;
//
//    @Column(name = "real_name")
//    private String reallName;
//
//    /**
//     * 多对多
//     * joincolumns需要将此entity中的什么字段添加到表的什么字段，name是存储在多对多关系表中的字段名，referencedColumnName为此外键
//     * inverseJoinColumns,name字段是关系entity Role的id以role_id存储在关系表tyg_user_role中
//     */
//    @ManyToMany
//    @JoinTable(					//jointable。维护方加此注释name="tyg_user_role",		//name是表名，
//    joinColumns={@JoinColumn(name="person_id", referencedColumnName="id")},
//    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="ID")})
//    private List<Role> roles;
}

package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

//@Data
//@Entity
//@Table(name = "zhao_role")
public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
//    private Long id;    //id
//
//    @Column(name = "role_name")
//    private String roleName; //角色
//
//    @Column(name = "role_desc")
//    private String roleDes;// uese介绍
//
//    /**
//     * 多对多不维护的一方属性，只写mappedBy，值和维护方的属性值一致
//     */
//    @ManyToMany(mappedBy = "roles")
//    private List<Person> person;//人员集合
}

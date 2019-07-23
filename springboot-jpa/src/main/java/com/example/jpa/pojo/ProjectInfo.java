package com.example.jpa.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Data
@Entity
@Table(name="project_info")
public class ProjectInfo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;//id

    @Column(name="name")
    private String name;//姓名

    @ManyToMany(mappedBy="projects",fetch=FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)   //NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    private List<Employee> employees = new ArrayList<Employee>();

}
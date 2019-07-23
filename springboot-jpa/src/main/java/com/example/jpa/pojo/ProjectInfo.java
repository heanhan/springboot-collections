package com.example.jpa.pojo;

import lombok.Data;

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

    @ManyToMany(mappedBy="projects")
    private List<Employee> employees = new ArrayList<Employee>();

}
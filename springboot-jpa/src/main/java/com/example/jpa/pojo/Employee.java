package com.example.jpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function :
 */

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="salary",columnDefinition="DECIMAL(10,2)")
    private BigDecimal salary;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="employee_project_inner", //中间表名
            //中间表product_id字段
            joinColumns={@JoinColumn(name="employee_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="project_id",referencedColumnName="id")}
    )
    private List<ProjectInfo> projects = new ArrayList<>();

}

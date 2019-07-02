package com.example.shiro.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_roles")
public class Roles {

    private String id;//主键

    private String role;//角色
}

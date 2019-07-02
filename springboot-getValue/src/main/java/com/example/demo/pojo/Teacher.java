package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@ConfigurationProperties(prefix="spring.teacher")
public class Teacher implements Serializable {

    private String name;

    private Integer age;

    private String gender;


}

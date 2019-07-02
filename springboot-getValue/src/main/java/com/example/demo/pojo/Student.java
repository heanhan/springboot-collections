package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix="spring.student")
public class Student implements Serializable {

    private String firstName;

    private String lastName;

    private Integer age;

    private String gender;

    private String city;

    private Teacher teacher;

    private List<String> hobbys;

    private Map<String,Integer> scores;
}

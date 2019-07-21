/**
 * 
 */
package com.example.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 用于测试mongo的计算
 * @author Thunisoft
 *
 */
@Data  //没生效性。暂时注释掉，
@Document(value="mongo-student")
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class Student implements Serializable{
	private static final long serialVersionUID = 3620068410249033911L;
	private int studentId;//学号
	private String name;//姓名
	private String sex;//性别
	private double hight;//升高
	private int age;//年龄
	private int  classGrade;//班级
	private String className;//班级名称
	private double score;//分数
	@ApiModelProperty(required = true, dataType = "date", value = "时间（2019-03-06 12:12:12）")  
    @ApiParam(defaultValue = "2019-03-06 12:12:12")  
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:dd:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:dd:ss",timezone="GMT+8")
	private Date birthday;//生日
	public Student() {
		super();
	}
	public Student(String name, String sex, double hight, int age, int classGrade, String className, double score,Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.hight = hight;
		this.age = age;
		this.classGrade = classGrade;
		this.className = className;
		this.score = score;
		this.birthday = birthday;
	}
	public Student(int studentId, String name, String sex, double hight, int age, int classGrade, String className,
			double score,Date birthday) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.sex = sex;
		this.hight = hight;
		this.age = age;
		this.classGrade = classGrade;
		this.className = className;
		this.score = score;
		this.birthday = birthday;
	}

}

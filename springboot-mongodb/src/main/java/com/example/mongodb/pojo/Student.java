/**
 * 
 */
package com.example.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 用于测试mongo的计算
 * @author Thunisoft
 *
 */
//@Data  没生效性。暂时注释掉，
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getClassGrade() {
		return classGrade;
	}
	public void setClassGrade(int classGrade) {
		this.classGrade = classGrade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", sex=" + sex + ", hight=" + hight + ", age="
				+ age + ", classGrade=" + classGrade + ", className=" + className + ", score=" + score + ", birthday="
				+ birthday + "]";
	}
	
}

/**
 * 
 */
package com.example.mongodb.dao;

import com.example.mongodb.pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author Thunisoft
 *
 */
public interface IStudentDao {
	/*
	 * 学生的增删改查
	 * 
	 */
	// 保存数据
	public void addStudentInfo(Student student);

	// 根据id删除mongo中对应数据
	public void removeStudentInfoById(int studentId);

	// 更新数据
	public void updateStudentInfo(Student student);

	// 根据id 查询mongo中数据
	public Student findStudnetInfoById(int sudentId);

	// 查询mongo中所有数据
	public List<Student> findAllStudnetInfo();

	/**
	 * 按照日期进行查询学生信息
	 * 
	 * @param birthday
	 * @return
	 */
	public Student findStudentByBirthday(Date birthday);

	/**
	 * 按照时间段查询记录
	 * 
	 * @param startparse
	 * @param endparse
	 * @return
	 */
	public List<Student> findStudentByBirthdayBetween(Date startparse, Date endparse);

	/**
	 * 动态条件查询
	 * 
	 * @param student
	 * @return
	 */
	public List<Student> dynamicConditionFindStudent(Student student);

	/*
	 * 
	 * 聚合函数使用 统计年龄总和，平均身高，男女生个数
	 * 
	 */
	// 聚合- 求和sum
	public double findStudentSumByCondition(Map<String, Object> map);

	// 聚合- 统计count
	public long findStudentCountByCondition(Map<String, Object> map);

}

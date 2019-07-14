/**
 * 
 */
package com.example.mongodb.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.mongodb.dao.IStudentDao;
import com.example.mongodb.pojo.Student;
import com.example.mongodb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Thunisoft
 *
 */
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao studentDaoImpl;

	/*
	 * 学生的增删改查
	 * 
	 */
	// 保存数据
	@Override
	public void addStudentInfo(Student student) {
		studentDaoImpl.addStudentInfo(student);
	}

	// 根据id删除mongo中对应数据
	@Override
	public void removeStudentInfoById(int studentId) {
		studentDaoImpl.removeStudentInfoById(studentId);
	}

	// 更新数据
	@Override
	public void updateStudentInfo(Student student) {
		studentDaoImpl.updateStudentInfo(student);
	}

	// 根据id 查询mongo中数据
	@Override
	public Student findStudnetInfoById(int sudentId) {
		return studentDaoImpl.findStudnetInfoById(sudentId);

	}

	// 查询mongo中所有数据
	@Override
	public List<Student> findAllStudnetInfo() {
		return studentDaoImpl.findAllStudnetInfo();

	}

	/**
	 * 按照日期进行查询学生信息
	 */
	public Student findStudentByBirthday(Date birthday) {
		return studentDaoImpl.findStudentByBirthday(birthday);
	}

	/**
	 * 按照时间段查询记录
	 * 
	 * @param startparse
	 * @param endparse
	 * @return
	 */
	public List<Student> findStudentByBirthdayBetween(Date startparse, Date endparse) {
		return studentDaoImpl.findStudentByBirthdayBetween(startparse, endparse);
	}

	/**
	 * 动态条件查询
	 * 
	 * @param student
	 * @return
	 */
	public List<Student> dynamicConditionFindStudent(Student student) {
		return studentDaoImpl.dynamicConditionFindStudent(student);
	}

	/*
	 * 
	 * 聚合函数使用 统计年龄总和，平均身高，男女生个数
	 * 
	 */
	// 聚合- 求和sum
	public double findStudentSumByCondition(Map<String, Object> map) 
	{
		return studentDaoImpl.findStudentSumByCondition(map);
	}

	// 聚合- 统计count
	public long findStudentCountByCondition(Map<String, Object> map) 
	{
		return studentDaoImpl.findStudentCountByCondition(map);
	}
}

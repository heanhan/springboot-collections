/**
 * 
 */
package com.example.mongodb.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.mongodb.dao.IStudentDao;
import com.example.mongodb.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


/**
 * @author Thunisoft
 *
 */
@Service
public class StudentDaoImpl implements IStudentDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void addStudentInfo(Student student) {
		mongoTemplate.save(student);
	}

	@Override
	public void removeStudentInfoById(int studentId) {
		mongoTemplate.remove(studentId);
	}

	@Override
	public void updateStudentInfo(Student student) {
		Query query = new Query(Criteria.where("studentid").is(student.getStudentId()));
		Update update = new Update();
		update.set("studentId", student.getStudentId());
		update.set("name", student.getName());
		update.set("age", student.getAge());
		update.set("hight", student.getHight());
		update.set("sex", student.getSex());
		update.set("score", student.getScore());
		update.set("className", student.getClassName());
		update.set("className", student.getClassGrade());
		mongoTemplate.updateFirst(query, update, Student.class);
	}

	@Override
	public Student findStudnetInfoById(int sudentId) {
		Query query = new Query(Criteria.where("studentId").is(sudentId));
		Student student = mongoTemplate.findOne(query, Student.class);
		return student;
	}

	@Override
	public List<Student> findAllStudnetInfo() {
		Query query = new Query();
		List<Student> studentList = mongoTemplate.find(query, Student.class);
		return studentList;
	}

	/**
	 * 按照日期进行查询学生信息
	 */
	public Student findStudentByBirthday(Date birthday) {
		Query query = new Query(Criteria.where("birthday").is(birthday));
		Student student = mongoTemplate.findOne(query, Student.class);
		return student;
	}

	/**
	 * 按照时间段查询记录
	 * 
	 * @param startparse
	 * @param endparse
	 * @return
	 */
	public List<Student> findStudentByBirthdayBetween(Date startparse, Date endparse) {
		Query query = new Query();
		// 用来构建条件
		Criteria criteria = Criteria.where("birthday").gte(startparse).lt(endparse);
		query.addCriteria(criteria);
		return mongoTemplate.find(query, Student.class);
	}

	/**
	 * mongoDB的多条件查询
	 */
	@Override
	public List<Student> dynamicConditionFindStudent(Student student) {
		Criteria criteria = new Criteria();
		criteria.where(" 1=1 ");
		/**
		 * 条件通过Criteria的and()方法往后追加
		 */
		if (student.getName() != null) {
			criteria.and("name").is(student.getName());
		}
		if (student.getSex() != null) {
			criteria.and("age").is(student.getSex());
		}
		if (student.getClassName() != null) {
			criteria.and("className").is(student.getClassName());
		}
		Query query = new Query(criteria);
		return mongoTemplate.find(query, Student.class);
	}

	// 聚合- 求和sum
	public double findStudentSumByCondition(Map<String, Object> map) {
		Criteria criteria=new Criteria();
		criteria.where(" 1=1 ");
		if(map.get("classname")!=null) 
		{
			criteria.and("classname").is(map.get("classname"));
		}
		if(map.get("classgrade")!=null) 
		{
			criteria.and("classgrade").is(map.get("classgrade"));
		}
		Query query=new Query(criteria);
		return 0;
	}

	// 聚合- 统计count
	public long findStudentCountByCondition(Map<String, Object> map) {
		Criteria criteria=new Criteria();
		criteria.where(" 1=1 ");
		if(map.get("classname")!=null) 
		{
			criteria.and("classname").is(map.get("classname"));
		}
		if(map.get("classgrade")!=null) 
		{
			criteria.and("classgrade").is(map.get("classgrade"));
		}
		Query query=new Query(criteria);
		return mongoTemplate.count(query, Student.class);
	}

}

package com.example.jackson.controller;


import com.example.jackson.entity.pojo.Book;
import com.example.jackson.entity.pojo.Teacher;
import com.example.jackson.entity.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class UserController {


    @ResponseBody
    @GetMapping(value = "/getUser")
    public User getUser(){
        User user=new User();
        user.setUserName("zhaojh0912");//姓名
        user.setAge(21);//年龄
        user.setPassword("123456");//密码
        user.setBirthday(new Date());//生日

        user.setHobby(new String[]{"篮球","足球","跑步","看书","听歌"});//爱好

        List<Book> bookList =new ArrayList<Book>();
        Book book =new Book();
        book.setId("book_001");
        book.setName("诗与远方");
        book.setCategory(new String[]{"文学","课外读物"});
        book.setPrice(27.9);
        book.setAuthor("zhoajh0912");
        book.setPublishTime(new Date());
        bookList.add(book);
        user.setBooks(bookList);


        List<String> roles = new ArrayList<>();//角色
        roles.add("班长");
        roles.add("文艺委员");
        roles.add("学生");

        user.setRoles(roles);


        Map<String,String> course= new HashMap<>();
        course.put("计算机","你选了计算机相关的课程，好好学吧");
        course.put("文学","好吧，陶冶一下情操");
        course.put("外语","多学一门外语，出门应对自如");
        user.setCourse(course);//添加所选的专业课程


        Map<String,List<Teacher>> courseTeacher= new HashMap<>();
        List<Teacher> teacherList= new ArrayList<>();
        List<Teacher> teacherList1= new ArrayList<>();
        Teacher teacher = new Teacher();//老师
        teacher.setId("00001");
        teacher.setName("老师1");
        teacher.setTeachCourse("课程一");
        teacherList.add(teacher);

        Teacher teacher2 = new Teacher();//老师
        teacher2.setId("00002");
        teacher2.setName("老师2");
        teacher2.setTeachCourse("课程二");
        teacherList1.add(teacher2);

        courseTeacher.put("课程一",teacherList);
        courseTeacher.put("课程二",teacherList1);

        user.setCourseTeacher(courseTeacher);
        return user;
    }
}

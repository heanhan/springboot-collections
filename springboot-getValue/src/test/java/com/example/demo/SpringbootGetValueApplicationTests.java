package com.example.demo;

import com.example.demo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootGetValueApplicationTests {

    @Autowired
    private Student student;

    @Test
    public void contextLoads() {
        System.out.println("s输出学生信息："+student.toString());
        Map<String, Integer> scores = student.getScores();
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("考试科目："+next.getKey()+" :"+next.getValue()+" 分");
        }

    }

}

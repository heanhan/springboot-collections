package com.example.email;

import com.example.email.controller.SingleMailController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEmailApplicationTests {

    @Autowired
    private SingleMailController sendTemplateMail;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTemplateMailTest() throws MessagingException {
        String to = "1763124707@qq.com";
        String subject = "Springboot 发送 模版邮件";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("username", "zhaojh0912");
        sendTemplateMail.sendTemplateMail(to, subject, paramMap, "sendMail");
    }

}

package com.example.email.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author : zhaojh
 * @date : 2019-11-14
 * @function :邮件服务
 *
 * 1：文本邮件是最简单也是最基础的一种邮件，使用 Spring 封装的 JavaMailSender 直接发送就可以了。
 */

@Slf4j
@RestController
@RequestMapping(value = "/mail")
public class SingleMailController {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;


    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单文本邮件
     * @param to 邮件的接收人
     * @param subject  主题
     * @param content 内容
     */
    @PostMapping(value = "/sendSimpleTextMail")
    public void sendSimpleTextMail(String to,String subject,String content){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);//发送的目标人
        simpleMailMessage.setSubject(subject);//主题
        simpleMailMessage.setFrom(from);//发送者
        simpleMailMessage.setText(content);//邮件的内容
        mailSender.send(simpleMailMessage);
        log.info("【文本邮件】成功发送！to={}",to);

    }

    /**
     *发送 html 邮件
     * @param to 邮件的接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws MessagingException
     */
    @PostMapping(value = "/sendHtmlMail")
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);//发送发
        mimeMessageHelper.setTo(to);//邮件的接收者
        mimeMessageHelper.setSubject(subject);//邮件主题
        mimeMessageHelper.setText(content,true);//邮件内容
        mailSender.send(mimeMessage);
        log.info("【HTML邮件】成功发送！to{}",to);

    }


    /**
     * 发送带有附件的邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param appendix 附件
     */
    @PostMapping(value = "/sendAppendixMail")
    public void sendAppendixMail(String to, String subject, String content, String... appendix) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(to);
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        messageHelper.setText(content,true);

        //添加邮件
        for(String filePath:appendix){
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            if(fileSystemResource.exists()){
                //判断附件的地址是否存在
                String filename = fileSystemResource.getFilename();//获取附件的名称
                messageHelper.addAttachment(filename,fileSystemResource);//添加附件
            }
        }
        mailSender.send(message);//发送邮件
        log.info("【附件邮件】成功发送！to={}", to);

    }


    /**
     * 带有图片的邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param imgMap 图片
     * @throws MessagingException
     */
    @PostMapping(value = "/sendImgMail")
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        // 添加图片
        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
            FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
            if (fileResource.exists()) {
                String filename = fileResource.getFilename();
                messageHelper.addInline(entry.getKey(), fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("【图片邮件】成功发送！to={}", to);
    }

    /**
     * 发送模版邮件
     *
     * @param to
     * @param subject
     * @param paramMap
     * @param template
     * @throws MessagingException
     */
    @PostMapping(value = "/sendTemplateMail")
    public void sendTemplateMail(String to, String subject, Map<String, Object> paramMap, String template)
            throws MessagingException {
        Context context = new Context();
        // 设置变量的值
        context.setVariables(paramMap);
        String emailContent = templateEngine.process(template, context);
        sendHtmlMail(to, subject, emailContent);
        log.info("【模版邮件】成功发送！paramsMap={}，template={}", paramMap, template);
    }

}

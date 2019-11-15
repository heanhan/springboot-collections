package com.example.email.service;

import com.example.email.entity.vo.MailVo;

public interface IMailService {


    /**
     * 发送邮件
     * @param mailVo 邮件
     * @return 邮件
     */
    MailVo sendMail(MailVo mailVo);

    /**
     * 检测邮件信息类
     * @param mailVo 邮件
     */
    void checkMail(MailVo mailVo);

    /**
     * 构建复杂邮件信息类
     * @param mailVo 邮件
     */
    void sendMimeMail(MailVo mailVo);

    /**
     * 保存邮件
     * @param mailVo 邮件
     * @return 邮件
     */
    MailVo saveMail(MailVo mailVo);

    /**
     * 获取邮件发信人
     * @return String
     */
    String getMailSendFrom();
}

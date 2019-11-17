package com.example.email.service.impl;

import com.example.email.entity.vo.MailVo;
import com.example.email.service.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-11-15
 * @function :邮件服务的业务实现层
 */

@Slf4j
@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    /**
     *发送邮件
     * @param mailVo 邮件
     * @return 邮件
     */
    @Override
    public MailVo sendMail(MailVo mailVo) {
        try{
            checkMail(mailVo);//检查邮件
            sendMimeMail(mailVo);//发送邮件
            return saveMail(mailVo);//保存邮件，并返回

        }catch (Exception e){
            log.error("发送邮件失败：",e);//打印错误信息
            mailVo.setStatus("fail");//保存失败状态
            mailVo.setError(e.getMessage());
            return mailVo;
        }
    }

    /**
     *检测邮件信息类
     * @param mailVo 邮件
     */
    @Override
    public void checkMail(MailVo mailVo) {
        /**
         * 先判断收件人是否为空
         */
        if(StringUtils.isEmpty(mailVo.getTo())){
            throw new RuntimeException("邮件收件人不能为空！");
        }
        if(StringUtils.isEmpty(mailVo.getSubject())){
            throw new RuntimeException("邮件主题不能为空！");
        }
        if(StringUtils.isEmpty(mailVo.getText())){
            throw new RuntimeException("邮件内容不能为空！");
        }

    }

    /**
     *构建复杂邮件信息类
     * @param mailVo 邮件
     */
    @Override
    public void sendMimeMail(MailVo mailVo) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
            mailVo.setFrom(getMailSendFrom());//获取发件人的配置项信息
            mimeMessageHelper.setFrom(mailVo.getFrom());//设置发件人
            mimeMessageHelper.setTo(mailVo.getTo());//设置收件人的信息
            mimeMessageHelper.setSubject(mailVo.getSubject());//设置邮件主题
            mimeMessageHelper.setText(mailVo.getText());//设置邮件内容
            if(!StringUtils.isEmpty(mailVo.getCc())){
                //抄送
                mimeMessageHelper.setCc(mailVo.getCc().split(","));
            }
            if(!StringUtils.isEmpty(mailVo.getBcc())){
                //密抄
                mimeMessageHelper.setBcc(mailVo.getBcc().split(","));
            }
            if(mailVo.getMultipartFiles()!=null){
                //添加附件
                for(MultipartFile multipartFile:mailVo.getMultipartFiles()){
                    mimeMessageHelper.addAttachment(multipartFile.getOriginalFilename(),multipartFile);
                }
            }
            if(StringUtils.isEmpty(mailVo.getSentDate()+"")){
                //发送时间
                mailVo.setSentDate(new Date());
                mimeMessageHelper.setSentDate(mailVo.getSentDate());//设置发送时间
            }
            javaMailSender.send(mimeMessageHelper.getMimeMessage());//正式发送邮件
            mailVo.setStatus("OK");
            log.info("发送邮件成功：{}-->{}",mailVo.getFrom(),mailVo.getTo());
        }catch (Exception e){
            throw new RuntimeException(e);//发送失败

        }

    }

    /**
     *保存邮件
     * @param mailVo 邮件
     * @return 邮件
     */
    @Override
    public MailVo saveMail(MailVo mailVo) {
        //可以选择将邮件保存到数据库
        return null;
    }

    /**
     *获取邮件发信人
     * @return String
     */
    @Override
    public String getMailSendFrom() {
        return javaMailSender.getJavaMailProperties().getProperty("from");
    }
}

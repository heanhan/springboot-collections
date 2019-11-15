package com.example.email.controller;

import com.example.email.entity.vo.MailVo;
import com.example.email.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : zhaojh
 * @date : 2019-11-15
 * @function :
 */

@RestController
@RequestMapping(value = "/advance")
public class MailController {

    @Autowired
    private IMailService mailService;


    /**
     * 跳转邮件发送界面
     * @return 发送邮件页面
     */
    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("mailpage.html");//打开发送邮件的页面
        modelAndView.addObject("from",mailService.getMailSendFrom());//邮件的发件人
        return modelAndView;
    }

    /**
     * 发送邮件
     * @return
     */
    @PostMapping(value = "/sendMail")
    public MailVo sendMail(MailVo mailVo, MultipartFile[] files){
        mailVo.setMultipartFiles(files);//设置附件信息
        return mailService.sendMail(mailVo);
    }


}

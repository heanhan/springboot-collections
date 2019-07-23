package com.example.springbootfastdfs.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author : zhaojh
 * @date : 2019-07-22
 * @function : 全局异常处理
 *              1、在类上添加注解@ControllerAdvice 增强处理器
 *              2、方法上添加注解@ExceptionHandler
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String filehandlerException(MultipartException e, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message",e.getCause().getMessage());
        return "redirect:/error";
    }
}

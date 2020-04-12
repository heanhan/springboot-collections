package com.example.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhaojh0912
 */
@RestController
@RequestMapping(value = "file")
@Slf4j
public class FielController {

    @PostMapping(value = "/uploadFile")
    public String uploadFile(MultipartFile files) throws IOException {
        String originalFilename = files.getOriginalFilename();
        long size = files.getSize();
        String contentType = files.getContentType();
        log.info("获取的文件名称："+originalFilename+",大小："+size+",文件类型："+contentType);

        return "success";
    }

}

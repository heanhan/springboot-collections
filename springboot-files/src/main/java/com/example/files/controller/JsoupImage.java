package com.example.files.controller;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping(value="/jsoup")
public class JsoupImage {


    @PostMapping(value = "/downUseJoupImag")
    public void downUseJoupImag(String urlImg) throws IOException {

        Connection.Response response =Jsoup.connect(urlImg).ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();
        //声明缓冲字节输入流

        BufferedInputStream bufferedInputStream = response.bodyStream();
        //缓冲字节输出流-》文件字节输出流-》文件
        File file = new File("D:\\timg.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //把缓冲字节输入流写入到输出流
        byte[] b = new byte[1024]; //每次最多读1KB的大小
        int length; //实际读入的字节
        while ((length = bufferedInputStream.read(b))!=-1){
            //写入到输出流
            bufferedOutputStream.write(b,0,length);
        }
        //刷新缓冲的输出流。这将强制将任何缓冲的输出字节写入底层输出流。
        bufferedOutputStream.flush();
        bufferedInputStream.close();

    }
}

package com.example.httpclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhaojh
 * @date : 2019-08-02
 * @function :
 */

@RestController
@RequestMapping(value = "/restTemp")
public class TestTemplateController {

    @Autowired
    private RestTemplate restTemplate;


    public void useRestTemplate(){

    }
}




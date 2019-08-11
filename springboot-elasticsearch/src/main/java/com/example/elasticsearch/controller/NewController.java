package com.example.elasticsearch.controller;

import com.example.elasticsearch.pojo.News;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-08-09
 * @function : news 控制器
 */

@RestController
@RequestMapping(value = "/news")
public class NewController {

    /**
     * 添加新闻
     * @return
     */
    @PostMapping(value = "/addNews")
    public String addNews(){

        return null;
    }


    /**
     * 根据条件查询
     * @return
     */
    @GetMapping(value = "/findByCondition")
    public Page<News> findByCondition(){
        return null;
    }
}

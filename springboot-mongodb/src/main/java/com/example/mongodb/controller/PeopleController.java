package com.example.mongodb.controller;

import com.example.mongodb.service.IPeopleService;
import com.example.mongodb.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-11-09
 * @function :mongo 的索引使用
 */

@RestController
@RequestMapping(value = "people")
public class PeopleController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IPeopleService peopleService;

    @GetMapping(value = "/findCollectionIndexInfo")
    public String findCollectionIndexInfo(){
        String collectionIndexInfo = peopleService.findCollectionIndexInfo();
        return collectionIndexInfo;
    }
}

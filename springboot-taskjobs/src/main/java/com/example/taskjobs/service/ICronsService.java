package com.example.taskjobs.service;

/**
 * @author : zhaojh
 * @date : 2019-08-23
 * @function :
 */

public interface ICronsService {

    //查询定时任务
    String findByCronId(Integer cronId);
}

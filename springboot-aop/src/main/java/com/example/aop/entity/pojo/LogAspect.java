package com.example.aop.entity.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-11-02
 * @function : 日志的实体
 */

@Data
public class LogAspect {

    private String id;//id  使用雪花算法进行生成
    private String userId;//访问人的id
    private String userName;//访问人
    private String url;//访问的路径
    private String method;//方法
    private String responseTime;//响应时间
    private boolean result;//访问的结果  success / fail
    private Date startTime;//访问时间
    private Date endTime;//结束时间

}

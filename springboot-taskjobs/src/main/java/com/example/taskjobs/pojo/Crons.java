package com.example.taskjobs.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-08-23
 * @function :定时任务的类
 */

@Slf4j
@Data
public class Crons {

    private Integer cronId;//定时任务的主键
    private String cronExpress;//定时任务的表达式
    private Date createTime;//创建时间
    private Date updateTime;//最后一次修改时间
    private String createUser;//创建人

}

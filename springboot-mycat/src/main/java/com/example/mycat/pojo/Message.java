package com.example.mycat.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : zhaojh
 * @date : 2019-07-14
 * @function :  消息实体
 */
@Data
@Entity
@Table(name = "mycat_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键


    @Column(name = "name")
    private String name;//消息类型


    @Column(name = "content")
    private String content;//消息内容


}

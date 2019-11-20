package com.example.kafka.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : zhaojh
 * @date : 2019-11-20
 * @function :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private String from; //来源

    private String message; //信息
}

package com.example.transactions.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : zhaojh
 * @date : 2019-07-31
 * @function : 银行卡
 *
 */

@Data
@Entity
@Table(name = "bank_card")
public class BankCard implements Serializable {

    @Id
    @Column(name = "card_id")
    private String cardId;//银行卡id

    @Column(name = "card_name")
    private String cardName;//银行卡名

    private Double money;//余额

    @Column(name = "card_credit")
    private Integer credit;//消费积分

    @ManyToOne
    @JoinColumn(name ="user_card" )
    private User user;//持有人

    @ManyToOne
    @JoinColumn(name ="bank_card" )
    private Bank bank;//所属银行
}

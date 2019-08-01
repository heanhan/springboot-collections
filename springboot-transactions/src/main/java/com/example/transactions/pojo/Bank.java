package com.example.transactions.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-31
 * @function : 银行
 */

@Data
@Entity
@Table(name = "b_bank")
public class Bank implements Serializable {

    @Id
    @Column(name = "bank_id")
    private String bankId;//id

    @Column(name = "bank_name")
    private String bankName;//名称

    @Column(name = "phone")
    private String phone;//联系方式

    @Column(name = "address")
    private String address;//地址

    @OneToMany(mappedBy = "bank")
    private List<BankCard> bankCardList;//银行卡


}

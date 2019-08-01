package com.example.transactions.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-07-31
 * @function :用户
 */

@Data
@Entity
@Table(name = "b_user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;//id

    @Column(name = "user_name")
    private String userName;//用户名

    @OneToMany(mappedBy = "user")
    private List<BankCard> bankCardList;//持有的银行卡


}

package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(name = "ACCOUNT_IDX_01", columnList = "email")})
public class Account extends BaseModel{
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String firstname;
    @Column(length = 30, nullable = false)
    private String lastname;
    private Integer age;
    @Column(length = 50)
    private String address;
    @OneToMany
    private List<CreditCard> creditCard;

}

package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMERS", indexes = {@Index(name = "CUSTOMER_IDX_01", columnList = "email")})
public class CreditCard extends BaseModel{
    @Column(length = 12, nullable = false, unique = true)
    private int cardNumber;
    @Column(length = 30, nullable = false)
    private  String holderName;
    @Column(length = 5, nullable = false)
    private String expirationDate;
    @Column(length = 3, nullable = false)
    private int threeDigitCode;
}

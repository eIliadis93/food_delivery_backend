package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(name = "CUSTOMER_IDX_01", columnList = "email")})
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
    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards;

}

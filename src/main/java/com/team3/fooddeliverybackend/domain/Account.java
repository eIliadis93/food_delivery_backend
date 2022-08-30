package com.team3.fooddeliverybackend.domain;

import com.sun.istack.NotNull;
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
@Table(name = "ACCOUNTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
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

    @ToString.Exclude
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @NotNull
    private Set<CreditCard> creditCard;

}

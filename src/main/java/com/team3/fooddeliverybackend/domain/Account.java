package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private String email;
    @NotNull
    @Column(length = 25, nullable = false)
    private String password;
    @NotNull
    @Column(length = 20, nullable = false)
    private String firstname;
    @NotNull
    @Column(length = 30, nullable = false)
    private String lastname;
    private Integer age;
    @ToString.Exclude
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Address> addresses;
    @ToString.Exclude
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //@NotNull
    private Set<CreditCard> creditCards;

}

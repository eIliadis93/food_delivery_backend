package com.team3.fooddeliverybackend.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CREDITCARD")
@SequenceGenerator(name = "idGenerator", sequenceName = "CREDITCARD_SEQ", initialValue = 1, allocationSize = 1)
public class CreditCard extends BaseModel {
    @Column(length = 16, nullable = false, unique = true)
    @NotNull
    private Long cardNumber;
    @Column(length = 30, nullable = false)
    @NotNull
    private String holderName;
    @Column(length = 5, nullable = false)
    @NotNull
    private String expirationDate;
    @Column(length = 3, nullable = false)
    @NotNull
    private int threeDigitCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private Account account;
}

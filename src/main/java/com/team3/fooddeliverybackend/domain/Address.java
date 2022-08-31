package com.team3.fooddeliverybackend.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel{

    @Column(length = 50, nullable = false)
    @NotNull
    private String streetName;
    @Column(length = 5, nullable = false)
    @NotNull
    private int streetNumber;
    @Column(length = 20, nullable = false)
    @NotNull
    private String town;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Account account;
}

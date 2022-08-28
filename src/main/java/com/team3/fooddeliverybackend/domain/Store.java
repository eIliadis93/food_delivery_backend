package com.team3.fooddeliverybackend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STORES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
public class Store extends BaseModel {

    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String email;
    @Column(length = 10)
    private int phoneNumber;
    @Column(length = 30, nullable = false)
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private StoreCategory storeCategory;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private Menu menu;


}

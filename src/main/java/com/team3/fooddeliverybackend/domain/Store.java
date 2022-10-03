package com.team3.fooddeliverybackend.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "STORES", indexes = {@Index(name = "STORES_IDX_01", columnList = "name")})
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
public class Store extends BaseModel {

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false, unique = true)
    @NotNull
    private String email;

    @Column(length = 10)
    @NotNull
    private int phoneNumber;

    @Column(length = 30, nullable = false)
    @NotNull
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NotNull
    private StoreCategory storeCategory;

    @Column
    private String imgURL;

    @ToString.Exclude
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products;

    @ToString.Exclude
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Order> orders;


}

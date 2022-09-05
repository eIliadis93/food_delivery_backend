package com.team3.fooddeliverybackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STORE_PRODUCTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORE_PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class StoreProduct extends BaseModel{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JsonIgnore
    private Store store;

    @Column
    private String imgURL;

    @Column(precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal price;

}

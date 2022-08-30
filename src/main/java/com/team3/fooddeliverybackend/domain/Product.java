package com.team3.fooddeliverybackend.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS", indexes = {@Index(name = "PRODUCT_IDX_01", columnList = "serial"),})
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {
    @Column(length = 50, nullable = false)
    @NotNull
    private String name;
    @Column(length = 30, nullable = false, unique = true)
    @NotNull
    private String serial;
    @Column(precision = 10, scale = 2, nullable = true)
    @NotNull
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    @NotNull
    private ProductCategory productCategory;
}

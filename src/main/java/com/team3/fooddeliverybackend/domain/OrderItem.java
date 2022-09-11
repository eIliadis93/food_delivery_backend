package com.team3.fooddeliverybackend.domain;

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
@Table(name = "ORDER_ITEMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_ITEMS_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem extends BaseModel {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @NotNull
//    @JsonIgnore
//    private Order order;

    @Column(nullable = false)
    @NotNull
    private Integer quantity;

    @Column(precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal price;

}

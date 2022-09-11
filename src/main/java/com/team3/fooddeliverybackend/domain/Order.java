package com.team3.fooddeliverybackend.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")

@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JsonIgnore
    private Account account;
    @ToString.Exclude

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal payAmount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JsonIgnore
    private Store store;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NotNull
    private PaymentMethod paymentMethod;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date submitDate;
}

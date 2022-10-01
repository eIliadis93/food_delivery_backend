package com.team3.fooddeliverybackend.domain.transfer;

import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.PaymentMethod;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutRequest {
    private Set<OrderItemDto> orderItems;
    private PaymentMethod paymentMethod;
    private Long accountId;
    private Long storeId;
}

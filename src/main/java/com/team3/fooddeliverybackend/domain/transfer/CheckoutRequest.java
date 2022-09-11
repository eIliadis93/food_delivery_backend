package com.team3.fooddeliverybackend.domain.transfer;

import com.team3.fooddeliverybackend.domain.OrderItem;
import com.team3.fooddeliverybackend.domain.PaymentMethod;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

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

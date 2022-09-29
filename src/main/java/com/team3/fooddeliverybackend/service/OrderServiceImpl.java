package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.domain.transfer.CheckoutRequest;
import com.team3.fooddeliverybackend.domain.transfer.OrderItemDto;
import com.team3.fooddeliverybackend.repository.AccountRepository;
import com.team3.fooddeliverybackend.repository.OrderRepository;
import com.team3.fooddeliverybackend.repository.ProductRepository;
import com.team3.fooddeliverybackend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }


    private final AccountRepository accountRepository;

    private final StoreRepository storeRepository;

    private final ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Order checkout(CheckoutRequest checkoutRequest) {
        Order order = new Order();
        Account account = accountRepository.findById(checkoutRequest.getAccountId()).get();
        Store store = storeRepository.findById(checkoutRequest.getStoreId()).get();
        order.setOrderItems(createOrderItemList(checkoutRequest));
        order.setPayAmount(givePayAmount(order));
        order.setPaymentMethod(checkoutRequest.getPaymentMethod());
        order.setAccount(account);
        order.setStore(store);
        order.setSubmitDate(new Date()); //Date.from(Instant.now())
        return create(order);
    }


    private List<OrderItem> createOrderItemList(CheckoutRequest checkoutRequest){

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto oi : checkoutRequest.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            Product product = productRepository.findById(oi.getProductId()).get();
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(oi.getQuantity());
            orderItem.setProduct(product);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private BigDecimal givePayAmount(Order order) {
        //@formatter:off
        BigDecimal totalCost = order.getOrderItems().stream()
                .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //@formatter:on
        return totalCost;
    }

    public List<Order> getOrdersById(Long Id) {
        return orderRepository.getOrdersById(Id);
    }

}

package com.team3.fooddeliverybackend.service;


import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.domain.transfer.CheckoutRequest;

import java.util.List;
import java.util.Set;

public interface OrderService extends BaseService<Order> {
    Order initiateOrder(Account account);

    void addItem(Order order, Product product, int quantity);

    void updateItem(Order order, Product product, int quantity);

    void removeItem(Order order, Product product);


    List<Order> getOrdersById(Long Id);
    Order checkout(CheckoutRequest checkoutRequest);


}

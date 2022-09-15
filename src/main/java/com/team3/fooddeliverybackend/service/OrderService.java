package com.team3.fooddeliverybackend.service;


import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.transfer.CheckoutRequest;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    Order initiateOrder(Account account);

    void addItem(Order order, Product product, int quantity);

    void updateItem(Order order, Product product, int quantity);

    void removeItem(Order order, Product product);


    List<Order> getOrdersById(Long Id);
    Order checkout(CheckoutRequest checkoutRequest);


}

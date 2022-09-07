package com.team3.fooddeliverybackend.service;


import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.PaymentMethod;
import com.team3.fooddeliverybackend.domain.Product;

import java.util.Set;

public interface OrderService extends BaseService<Order> {
    Order initiateOrder(Account account);

    void addItem(Order order, Product product, int quantity);

    void updateItem(Order order, Product product, int quantity);

    void removeItem(Order order, Product product);

    Order checkout(Order order, PaymentMethod paymentMethod);
    Set<Order> getOrdersByAccount(Account account);

}

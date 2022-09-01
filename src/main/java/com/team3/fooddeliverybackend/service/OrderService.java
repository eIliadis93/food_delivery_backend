package com.team3.fooddeliverybackend.service;


import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.PaymentMethod;
import com.team3.fooddeliverybackend.domain.StoreProduct;

public interface OrderService extends BaseService<Order> {
	Order initiateOrder(Account account);

	void addItem(Order order, StoreProduct storeProduct, int quantity);

	void updateItem(Order order, StoreProduct storeProduct, int quantity);

	void removeItem(Order order, StoreProduct storeProduct);

	Order checkout(Order order, PaymentMethod paymentMethod);

	Order getLazy(Long id);

}

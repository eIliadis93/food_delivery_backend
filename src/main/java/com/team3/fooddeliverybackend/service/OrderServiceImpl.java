package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
	@Autowired
	private final OrderRepository orderRepository;

	@Override
	public JpaRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	@Override
	public Order initiateOrder(Account account) {
		return Order.builder().account(account).orderItems(new HashSet<>()).submitDate(new Date()).build();
	}

	@Override
	public void addItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		boolean increasedQuantity = false;

		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
		for (OrderItem oi : order.getOrderItems()) {
			if (oi.getProduct().getSerial().equals(product.getSerial())) {
				oi.setQuantity(oi.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}

		if (!increasedQuantity) {
			order.getOrderItems().add(newOrderItem(order, product, quantity));
		}

		logger.debug("Product[{}] added to Order[{}]", product, order);
	}

	@Override
	public void updateItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		order.getOrderItems().add(newOrderItem(order, product, quantity));

		logger.debug("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(Order order, Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		logger.debug("Product[{}] removed from Order[{}]", product, order);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public Order checkout(Order order, PaymentMethod paymentMethod) {
		if (!validate(order)) {
			logger.warn("Order should have customer, order items, and payment type defined before being able to " +
								"checkout the order.");
			return null;
		}

		order.setPaymentMethod(paymentMethod);
		order.setSubmitDate(new Date());
		order.setPayAmount(givePayAmount(order));

		return create(order);
	}

	@Override
	public Order getLazy(Long id) {
		Optional<Order> order = orderRepository.getLazy(id);
		if (order.isPresent()) {
			return order.get();
		}
		throw new NoSuchElementException(String.format("There was no order found matching id %d.", id));
	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null.");
			return true;
		}
		return false;
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getAccount() != null;
	}

	private OrderItem newOrderItem(Order order, Product product, int quantity) {
		return OrderItem.builder().product(product).order(order).quantity(quantity).price(product.getPrice()).build();
	}

	private BigDecimal givePayAmount(Order order) {
		//@formatter:off
		BigDecimal totalCost = order.getOrderItems().stream()
									   .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
									   .reduce(BigDecimal.ZERO, BigDecimal::add);
		//@formatter:on
		logger.debug("Order[{}], totalCost: {}.", order.getId(), totalCost);

		return totalCost;
	}

}

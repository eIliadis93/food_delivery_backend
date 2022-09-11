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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public Order initiateOrder(Account account) {
        return Order.builder().account(account).orderItems(new ArrayList<>()).submitDate(new Date()).build();
    }
	private final AccountRepository accountRepository;

	private final StoreRepository storeRepository;

	private final ProductRepository productRepository;

    @Override
    public void addItem(Order order, Product product, int quantity) {
        if (checkNullability(order, product)) {
            return;
        }

        boolean increasedQuantity = false;

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
	public Order checkout(CheckoutRequest checkoutRequest) {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();

		Account account = accountRepository.findById(checkoutRequest.getAccountId()).get();
		Store store = storeRepository.findById(checkoutRequest.getStoreId()).get();

		BigDecimal totalOrderAmount = new BigDecimal(0);
		for (OrderItemDto oi : checkoutRequest.getOrderItems())
		{
			OrderItem orderItem = new OrderItem();
			Product product = productRepository.findById(oi.getProductId()).get();
			orderItem.setPrice(product.getPrice());
			orderItem.setQuantity(oi.getQuantity());
			orderItem.setProduct(product);
			BigDecimal totalOrderItemAmount = product.getPrice().multiply(new BigDecimal(oi.getQuantity()));
			totalOrderAmount = totalOrderAmount.add(totalOrderItemAmount);
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		order.setPayAmount(totalOrderAmount);

		order.setPaymentMethod(checkoutRequest.getPaymentMethod());
		order.setAccount(account);
		order.setStore(store);
		order.setSubmitDate(new Date()); //Date.from(Instant.now())

        return create(order);
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
        return OrderItem.builder().product(product).quantity(quantity).price(product.getPrice()).build();
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

    public List<Order> getOrdersById(Long Id) {
        return orderRepository.getOrdersById(Id);
    }


}

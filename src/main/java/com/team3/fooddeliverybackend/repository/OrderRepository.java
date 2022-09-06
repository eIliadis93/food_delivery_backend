package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query(value = "update Order o set o.payAmount=:cost where o.id = :id")
    void updateOrderCost(Long id, BigDecimal cost);

    @Query(value = "SELECT * FROM ORDERS o WHERE o.orderitems", nativeQuery = true)
    Set<OrderItem> getOrderItems(Order order);
}

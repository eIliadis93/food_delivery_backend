package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

        Optional<Order> getLazy(Long id);


        void updateOrderCost(Long id, BigDecimal cost);
}

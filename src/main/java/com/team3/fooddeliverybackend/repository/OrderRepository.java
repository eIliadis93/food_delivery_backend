package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM ORDERS o WHERE o.ACCOUNT_ID=:Id", nativeQuery = true)
    List<Order> getOrdersById(Long Id);

}

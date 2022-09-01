package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

        @Query("select distinct o from Order o join fetch o.account join fetch o.orderItems oi join fetch oi.storeProduct where o.id = :id")
        @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
        Optional<Order> getLazy(Long id);

        @Modifying
        @Query(value = "update Order o set o.payAmount=:cost where o.id = :id", nativeQuery = false)
        void updateOrderCost(Long id, BigDecimal cost);
}

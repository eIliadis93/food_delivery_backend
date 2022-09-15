package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySerial(@NotNull String serial);

    List<Product> findProductByStore(@NotNull Store store);

//    @Query(value = "SELECT order_items.product_id FROM products\n" +
//            "INNER JOIN order_items\n" +
//            "ON products.id = order_items.product_id\n" +
//            "GROUP BY products.id\n" +
//            "ORDER BY SUM(order_items.quantity) DESC\n" +
//            "FETCH FIRST 10 ROWS ONLY", nativeQuery = true)


    @Query(value = "select p.* , (select SUM(oi.quantity) from ORDER_ITEMS oi where p.ID = oi.PRODUCT_ID) AS TOP10 FROM PRODUCTS p ORDER BY TOP10 DESC FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
    List<Product> findTop10Products();
}

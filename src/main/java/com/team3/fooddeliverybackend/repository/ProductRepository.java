package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySerial(String serial); //explanation
}

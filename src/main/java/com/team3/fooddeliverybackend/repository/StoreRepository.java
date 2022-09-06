package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    @Query(value = "SELECT * FROM STORES s WHERE s.products", nativeQuery = true)
    Set<Product> getProductsList(Store store);
}


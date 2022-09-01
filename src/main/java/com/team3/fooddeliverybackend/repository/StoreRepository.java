package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.domain.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);
    Store findByStoreCategory(StoreCategory storeCategory);

    List<StoreProduct> getStoreProductList(Store store);
}

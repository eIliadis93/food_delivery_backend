package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.domain.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    @Query(value = "SELECT * FROM STORES s WHERE s.storeproducts", nativeQuery = true)
    Set<StoreProduct> getStoreProductList(Store store);

//    void addStoreProduct(Store store, Product product);
//
//    void updateStoreProducts(Store store, Product product);
//
//    void removeStoreProducts(Store store, Product product);
}

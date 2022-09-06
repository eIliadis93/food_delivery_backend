package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;

import java.util.List;
import java.util.Set;

public interface StoreService extends BaseService<Store> {

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    //    void addStoreProduct(Store store, Product product);
//
//    void updateStoreProducts(Store store, Product product);
//
//    void removeStoreProducts(Store store, Product product);
//
    Set<Product> getProductsList(Store store);

}

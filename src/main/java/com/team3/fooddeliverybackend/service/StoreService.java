package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;

import java.util.List;

public interface StoreService extends BaseService<Store> {

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    void addProducts(Store store, Product product);

    void removeProducts(Store store, Product product);

}

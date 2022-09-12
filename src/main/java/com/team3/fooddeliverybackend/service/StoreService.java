package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface StoreService extends BaseService<Store> {

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    void addProducts(Store store, Product product);

    void removeProducts(Store store, Product product);
    List<Store> findMostPopularStoresByCategory(StoreCategory storeCategory);
    List<Store> findMostPopularStores();

}

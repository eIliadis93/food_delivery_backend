package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.domain.StoreProduct;

import java.util.List;
import java.util.Set;

public interface StoreService extends BaseService<Store>{

    Store findByName(String name);

    List<Store> findByStoreCategory(StoreCategory storeCategory);

    void addStoreProduct(Store store, StoreProduct storeProduct);

    void updateStoreProduct(Store store, StoreProduct storeProduct);

    void removeStoreProduct(Store store , StoreProduct storeProduct);

    Set<StoreProduct> getStoreProductList(Store store);

}

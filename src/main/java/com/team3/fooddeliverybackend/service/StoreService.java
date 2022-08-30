package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;

public interface StoreService extends BaseService<Store>{

    Store findByName(String name);

    Store findByStoreCategory(StoreCategory storeCategory);

    void addProduct(Store store, Product product);

    void updateProduct(Store store, Product product);

    void removeProduct(Store store , Product product);

}

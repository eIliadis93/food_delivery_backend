package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductService extends BaseService<Product> {
    Product findBySerial(String serial);

    List<Product> findProductByStore(@NotNull Store store);
}

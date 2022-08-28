package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;

public interface ProductService extends BaseService<Product>{
    Product findBySerial(String serial);
}

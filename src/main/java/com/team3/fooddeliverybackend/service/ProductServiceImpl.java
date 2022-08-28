package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Product findBySerial(final String serial) {
        return productRepository.findBySerial(serial);
    }

}

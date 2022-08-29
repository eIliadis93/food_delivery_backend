package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService{

    @Autowired
    private final StoreRepository storeRepository;

    @Override
    public JpaRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    @Override
    public Store findByName(String name) {
        if(storeRepository.findByName(name).getName() == null){
            logger.info("Stores with name {} does not exist.", name);
        }
        return storeRepository.findByName(name);
    }

    @Override
    public Store findByCategory(StoreCategory storeCategory) {
        return null;
    }

    @Override
    public void addProduct(Store store, Product product) {

    }

    @Override
    public void updateProduct(Store store, Product product) {

    }

    @Override
    public void removeProduct(Store store, Product product) {

    }

    @Override
    public List<Product> createMenu(Product... products) {
        return null;
    }
}

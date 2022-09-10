package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public JpaRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    @Override
    public Store findByName(String name) {
        if (storeRepository.findByName(name).getName() == null) {
            logger.info("Stores with name {} does not exist.", name);
        }
        return storeRepository.findByName(name);
    }

    @Override
    public List<Store> findByStoreCategory(final StoreCategory storeCategory) {
        logger.info("Searching store by category {}.", storeCategory);
        return storeRepository.findByStoreCategory(storeCategory);
    }

    @Override
    public void addProducts(Store store, Product product) {
        store.getProducts().add(product);
        logger.info("Product {} added to Store {}.", product, store);
    }

    @Override
    public void removeProducts(Store store, Product product) {
        store.getProducts().remove(product);
        logger.info("Product {} removed from Store {}.", product, store);
    }


}

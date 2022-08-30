package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService{

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
    public Store findByCategory(final StoreCategory storeCategory) {
        logger.info("Searching store by category {}.", storeCategory);
        return storeRepository.findByStoreCategory(storeCategory);
    }

    @Override
    public void addProduct(Store store, Product product) {
        store.getProductList().add(product);
        logger.info("Product {} has been added to Store {}", product, store);
    }

    @Override
    public void updateProduct(Store store, Product product) {
        if(store.getProductList().contains(product)) {
            store.getProductList().removeIf(pr -> pr.getSerial().equals(product.getSerial()));
            store.getProductList().add(product);

            logger.info("Product[{}] updated in Store[{}]", product, store);
        }
        logger.info("Product with name {} does not exist in Store {}", product, store);
    }

    @Override
    public void removeProduct(Store store, Product product) {
        store.getProductList().remove(product);
        logger.info("Product {} has been removed from Store {}", product, store);
    }

}

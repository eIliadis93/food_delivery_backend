package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.domain.StoreProduct;
import com.team3.fooddeliverybackend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public List<Store> findByStoreCategory(final StoreCategory storeCategory) {
        logger.info("Searching store by category {}.", storeCategory);
        return storeRepository.findByStoreCategory(storeCategory);
    }

    @Override
    public void addStoreProduct(Store store, StoreProduct storeProduct) {
        storeRepository.getStoreProductList(store).add(storeProduct);
        logger.info("Product {} has been added to Store {}", storeProduct, store);
    }

    @Override
    public void updateStoreProduct(Store store, StoreProduct storeProduct) {
        if(storeRepository.getStoreProductList(store).contains(storeProduct)) {
            storeRepository.getStoreProductList(store).removeIf(sp -> sp.equals(storeProduct.getProduct().getSerial()));
            storeRepository.getStoreProductList(store).add(StoreProduct.builder().build());

            logger.info("Product[{}] updated in Store[{}]", storeProduct, store);
        }
        logger.info("Product with name {} does not exist in Store {}", storeProduct, store);
    }

    @Override
    public void removeStoreProduct(Store store, StoreProduct storeProduct) {
        storeRepository.getStoreProductList(store).remove(storeProduct);
        logger.info("Product {} has been removed from Store {}", storeProduct, store);
    }

    @Override
    public Set<StoreProduct> getStoreProductList(Store store) {
        return storeRepository.getStoreProductList(store);
    }




}

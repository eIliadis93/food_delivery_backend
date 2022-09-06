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

//    @Override
//    public void addStoreProduct(Store store, Product product) {
//        storeRepository.getStoreProductList(store).add(StoreProduct.builder().product(product).build());
//        logger.info("Product {} has been added to Store {}", product, store);
//    }
//
//    @Override
//    public void updateStoreProducts(Store store, Product product) {
//        if (storeRepository.getStoreProductList(store).contains(product)) {
//            storeRepository.getStoreProductList(store).removeIf(sp -> sp.equals(product.getSerial()));
//            storeRepository.getStoreProductList(store).add(StoreProduct.builder().build());
//
//            logger.info("Product[{}] updated in Store[{}]", product, store);
//        }
//        logger.info("Product with name {} does not exist in Store {}", product, store);
//    }
//
//    @Override
//    public void removeStoreProducts(Store store, Product product) {
//        storeRepository.getStoreProductList(store).remove(product);
//        logger.info("Product {} has been removed from Store {}", product, store);
//    }

    @Override
    public Set<StoreProduct> getStoreProductsList(Store store) {
        return storeRepository.getStoreProductList(store);
    }

}

package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(@NotNull String name);


    List<Store> findByStoreCategory(@NotNull StoreCategory storeCategory);
    @Query(value = "select s.* , (select count(*) from ORDERS o where s.ID = o.STORE_ID) AS TOP FROM STORES s where s.storecategory =?1  order by TOP desc ",nativeQuery = true)
    List<Store> findMostPopularStoresByCategory(String storeCategory);

    @Query(value = "select s.* , (select count(*) from ORDERS o where s.ID = o.STORE_ID) AS TOP FROM STORES s  order by TOP desc ",nativeQuery = true)
    List<Store> findMostPopularStores();

}


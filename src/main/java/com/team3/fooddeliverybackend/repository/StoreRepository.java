package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(@NotNull String name);

    List<Store> findByStoreCategory(@NotNull StoreCategory storeCategory);

}


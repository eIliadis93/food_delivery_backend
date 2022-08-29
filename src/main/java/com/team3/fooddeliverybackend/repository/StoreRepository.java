package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByName(String name);
    Store findByCategory(String email);
}

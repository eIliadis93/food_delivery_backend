package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Store;

public interface StoreService extends BaseService<Store>{

    Store findByName(String name);

    Store findByCategory(String email);
}

package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.domain.StoreProduct;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController extends BaseController<Store>{

    private final StoreService storeService;
    @Override
    protected BaseService<Store> getBaseService() {
        return storeService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<Store> findByName(@RequestParam String name){
        final Store byName = storeService.findByName(name);
        if(byName == null){
            throw  new NoSuchElementException("Store not found");
        }
        return ResponseEntity.ok(byName);
    }

    @GetMapping(params = "storeByCategory")
    public ResponseEntity<Store> findByStoreCategory(@RequestParam StoreCategory storeCategory){
        final Store byCategory = (Store) storeService.findByStoreCategory(storeCategory);
        if(byCategory == null){
            throw new NoSuchElementException("Store not found (by category)");
        }
        return ResponseEntity.ok(byCategory);

    }
}

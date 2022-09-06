package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.domain.StoreCategory;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.StoreService;
import com.team3.fooddeliverybackend.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController extends BaseController<Store> {

    private final StoreService storeService;

    @Override
    protected BaseService<Store> getBaseService() {
        return storeService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<ApiResponse<Store>> findByName(@RequestParam(value = "name") String name) {
        final Store byName = storeService.findByName(name);
        if (byName == null) {
            throw new NoSuchElementException("Store not found");
        }
        return ResponseEntity.ok(ApiResponse.<Store>builder().data(byName).build());
    }

    @GetMapping(params = "storeByCategory")
    public ResponseEntity<ApiResponse<List<Store>>> findByStoreCategory(@RequestParam StoreCategory storeCategory) {
        final List<Store> byCategory = storeService.findByStoreCategory(storeCategory);
        if (byCategory == null) {
            throw new NoSuchElementException("Store not found (by category)");
        }
        return ResponseEntity.ok(ApiResponse.<List<Store>>builder().data(byCategory).build());

    }
}

package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController extends BaseController<Product> {

    private final ProductService productService;
    @Override
    protected BaseService<Product> getBaseService() {
        return productService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<Product> findBySerial(@RequestParam String serial){
        final Product bySerial = productService.findBySerial(serial);
        if(bySerial == null){
            throw  new NoSuchElementException("Product not found");
        }
        return ResponseEntity.ok(bySerial);
    }
}

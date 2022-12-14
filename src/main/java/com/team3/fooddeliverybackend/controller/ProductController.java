package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.Store;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.ProductService;
import com.team3.fooddeliverybackend.service.StoreService;
import com.team3.fooddeliverybackend.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
@CrossOrigin
public class ProductController extends BaseController<Product> {

    private final ProductService productService;
    private final StoreService storeService;

    @Override
    protected BaseService<Product> getBaseService() {
        return productService;
    }

    @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<Product>> findBySerial(@RequestParam(value = "serial") String serial) {
        final Product bySerial = productService.findBySerial(serial);
        if (bySerial == null) {
            throw new NoSuchElementException("Product not found");
        }
        return ResponseEntity.ok(ApiResponse.<Product>builder().data(bySerial).build());
    }

    @GetMapping(params = "findByStore")
    public ResponseEntity<ApiResponse<List<Product>>> findProductByStore(@RequestParam(value = "findByStore") Store findByStore) {
        final List<Product> byStore = productService.findProductByStore(findByStore);
        if (byStore == null) {
            throw new NoSuchElementException("Product not found (by Store)");
        }
        return ResponseEntity.ok(ApiResponse.<List<Product>>builder().data(byStore).build());
    }

    @GetMapping(params = "findTop10Products")
    public ResponseEntity<ApiResponse<List<Product>>> findTop10Products() {
        final List<Product> top10products = productService.findTop10Products();
        if (top10products == null) {
            throw new NoSuchElementException("Products not found (by 10 popular)");
        }
        return ResponseEntity.ok(ApiResponse.<List<Product>>builder().data(top10products).build());
    }
}

package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.PaymentMethod;
import com.team3.fooddeliverybackend.domain.StoreProduct;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends BaseController<Order> {
    private final OrderService orderService;
    @Override
    protected BaseService<Order> getBaseService() { return orderService; }

    @PostMapping("{order}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody @PathVariable @Valid Order order, StoreProduct storeProduct, int quantity){
        orderService.addItem(order,storeProduct,quantity);
    }
    @DeleteMapping("{order}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@RequestBody @PathVariable @Valid Order order, StoreProduct storeProduct){
        orderService.removeItem(order,storeProduct);
    }

    @PutMapping("{order}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody @PathVariable @Valid Order order, StoreProduct storeProduct, int quantity){
        orderService.updateItem(order,storeProduct,quantity);
    }





}


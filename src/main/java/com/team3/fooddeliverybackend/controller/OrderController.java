package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.domain.transfer.CheckoutRequest;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends BaseController<Order> {
    private final OrderService orderService;

    @Override
    protected BaseService<Order> getBaseService() {
        return orderService;
    }

    @PostMapping("{order}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody @PathVariable @Valid Order order, Product product, int quantity) {
        orderService.addItem(order, product, quantity);
    }

    @DeleteMapping("{order}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@RequestBody @PathVariable @Valid Order order, Product product) {
        orderService.removeItem(order, product);
    }

    @PutMapping("{order}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody @PathVariable @Valid Order order, Product product, int quantity) {
        orderService.updateItem(order, product, quantity);
    }

//    @GetMapping("/checkout")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void checkOut(@RequestBody @PathVariable @Valid Order order, PaymentMethod paymentMethod){
//        orderService.checkout(order,paymentMethod);
//    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void checkout(@RequestBody CheckoutRequest checkoutRequest) {
        orderService.checkout(checkoutRequest);
    }

    @RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
    public List<Order> getOrders(@RequestParam Long Id) {
        return orderService.getOrdersById(Id);
    }


}


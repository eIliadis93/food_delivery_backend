package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Order;
import com.team3.fooddeliverybackend.domain.transfer.CheckoutRequest;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.OrderService;
import com.team3.fooddeliverybackend.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
@CrossOrigin
public class OrderController extends BaseController<Order> {
    private final OrderService orderService;

    @Override
    protected BaseService<Order> getBaseService() {
        return orderService;
    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResponse> checkout(@RequestBody CheckoutRequest checkoutRequest) {
        final Order checkout = orderService.checkout(checkoutRequest);
        return ResponseEntity.ok(ApiResponse.builder().data(checkout).build());
    }

    @RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<Order>>> getOrders(@RequestParam Long Id) {
        final List<Order> orderHistory = orderService.getOrdersById(Id);
        return ResponseEntity.ok(ApiResponse.<List<Order>>builder().data(orderHistory).build());
    }


}


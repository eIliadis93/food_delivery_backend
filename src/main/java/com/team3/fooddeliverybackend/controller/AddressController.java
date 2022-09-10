package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.service.AddressService;
import com.team3.fooddeliverybackend.service.BaseService;
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
@RequestMapping("addresses")
public class AddressController extends BaseController<Address> {

    private final AddressService addressService;

    @Override
    protected BaseService<Address> getBaseService() {
        return addressService;
    }

    @GetMapping(params = "findByAccount")
    public ResponseEntity<ApiResponse<List<Address>>> findAddressByAccount(@RequestParam(value = "findByAccount") Account findByAccount) {
        final List<Address> byAccount = addressService.findAddressByAccount(findByAccount);
        if (byAccount == null) {
            throw new NoSuchElementException("Address not found (by account)");
        }
        return ResponseEntity.ok(ApiResponse.<List<Address>>builder().data(byAccount).build());
    }
}
